package org.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: hanchaowei
 * @date 2024/5/5
 * @description: CompletionService实现Forking
 */

public class CompletionServiceForking {

	public Integer geocoderByS1() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return 1;
	}

	public Integer geocoderByS2() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return 2;
	}

	public Integer geocoderByS3() {
		return 3;
	}

	public void save(Integer n) {
		System.out.println(n);
	}

	/**
	 * 该方法模拟并发请求三个服务，只要有一个成功返回，则返回结果
	 * @return
	 */
	public Integer example() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		CompletionService<Integer> cs = new ExecutorCompletionService<>(executorService);
		List<Future<Integer>> futures = new ArrayList<>(3);
		// 提交异步任务保存到futures
		futures.add(cs.submit(() -> geocoderByS1()));
		futures.add(cs.submit(() -> geocoderByS2()));
		futures.add(cs.submit(() -> geocoderByS3()));
		// 获取最先返回任务的结果
		Integer r = 0;
		try {
			// 只要有一个成功返回，则 break
			for (int i = 0; i < 3; ++i) {
				r = cs.take().get();
				// 简单地通过判空来检查是否成功返回
				if (r != null) {
					break;
				}
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			// 取消所有任务
			for(Future<Integer> f : futures)
				f.cancel(true);
		}
		// 返回结果
		return r;

	}

	public static void main(String[] args) {
		CompletionServiceForking completionServiceForking = new CompletionServiceForking();
		Integer example = completionServiceForking.example();
		System.out.println(example);
	}

}

package org.example.thread;

import java.util.concurrent.*;

/**
 * @author: hanchaowei
 * @date 2024/5/5
 * @description: CompletionService示例
 */

public class CompletionServiceExample {

	public Integer getPriceByS1() {
		return 1;
	}

	public Integer getPriceByS2() {
		return 2;
	}

	public Integer getPriceByS3() {
		return 3;
	}

	public void save(Integer n) {
		System.out.println(n);
	}

	public void example() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		// 创建CompletionService
		CompletionService<Integer> cs = new ExecutorCompletionService<>(executorService);
		// 向电商1询价
		cs.submit(this::getPriceByS1);
		// 向电商2询价
		cs.submit(this::getPriceByS2);
		// 向电商3询价
		cs.submit(this::getPriceByS3);
		// 将询价结果异步保存到数据库
		for (int i = 0; i < 3; i++) {
			try {
				// take方法等待结果并返回一个Future。按完成顺序获取结果
				Integer result = cs.take().get();
				executorService.execute(() -> save(result));
			} catch (InterruptedException | ExecutionException e) {
				throw new RuntimeException(e);
			}

		}
	}


	public static void main(String[] args) {
		CompletionServiceExample completionServiceExample = new CompletionServiceExample();
		completionServiceExample.example();
	}

}

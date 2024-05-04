package org.example.juc;

import java.util.concurrent.*;

/**
 * @author: hanchaowei
 * @date 2024/5/3
 * @description: 通过Callable和Future实现一个简单的线程池
 */

public class CallableExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);

		Callable<String> stringCallable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "callable example result";
			}
		};
		// 通过submit方法提交一个Callable任务
		Future<String> future = executorService.submit(stringCallable);

		try {
			// 阻塞直到任务完成
			String s = future.get();
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 关闭线程池
		executorService.shutdown();
	}

}

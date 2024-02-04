package org.example.thread.pool.threadexception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: hanchaowei
 * @date 2024/2/1
 * @description:
 */

public class ExecutorsExample {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		// 使用execute提交任务，无返回值
		executor.execute(() -> {System.out.println("通过execute提交任务");
		throw new RuntimeException("execute提交任务异常");});

		// 使用submit提交任务，有返回值
		Future<String> future = executor.submit(() -> {
			System.out.println("通过submit提交任务");
			throw new RuntimeException("submit提交任务异常");
		});

		try {
			String result = future.get(); // 这里会抛出ExecutionException
		} catch (ExecutionException e) {
			System.out.println("任务执行中抛出的异常: " + e.getCause().getMessage());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		executor.shutdown();
	}
}

package org.example.thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: hanchaowei
 * @date 2023/5/7
 * @description: 线程池中如何获取线程执行状态
 */

public class ThreadPoolExample {
	public static void main(String[] args) {
		// 创建一个固定大小的线程池
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		// 将任务提交给线程池并获取返回的Future对象
		Future<String> future = executorService.submit(new MyCallableTask());
		// 检查任务是否完成
		boolean isDone = future.isDone();
		System.out.println("任务是否完成: " + isDone);

		try {
			// 获取任务返回结果，如果任务未完成则一直阻塞
			String result = future.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭线程池
			executorService.shutdown();
		}

	}
}

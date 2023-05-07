package org.example.thread.pool.threadexception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: hanchaowei
 * @date 2023/5/7
 * @description: Callable和Runnable异常测试。
 */

public class CallableRunnableExceptionExample {
	public static void main(String[] args) {
		// 创建一个具有固定线程数的线程池。
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		// 测试Runnable异常
		Future<String> future1 = executorService.submit(new MyCallableTaskWithException());
		try {
			String result1 = future1.get();
			System.out.println("Callable任务执行结果: " + result1);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Callable任务抛出异常: " + e.getCause());
		}
		
		// 测试Runnable异常
		Future<?> future2 = executorService.submit(new MyRunnableTaskWithException());
		try {
			Object result2 = future2.get();
			System.out.println("Runnable任务执行结果: " + result2);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Runnable任务抛出异常: " + e.getCause());
		} finally {
			// 关闭线程池
			executorService.shutdown();
		}

	}
}

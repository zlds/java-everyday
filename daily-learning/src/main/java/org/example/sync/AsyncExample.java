package org.example.sync;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: hanchaowei
 * @date 2023/12/3
 * @description:
 */

public class AsyncExample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		System.out.println("任务1开始了: " + new Date());
		Future<?> future = executorService.submit(() -> {
			performTask();
		});
		System.out.println("Task 1 submitted: " + new Date());

		System.out.println("Task 2 started: " +  new Date());
		// 执行其他任务...
		System.out.println("Task 2 finished: " + new Date());
		// 等待异步任务完成(会阻塞主线程)。替代方案CompletableFuture
		future.get();
		System.out.println("Task 1 finished: " + new Date());
		executorService.shutdown();

	}


	public static void performTask() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

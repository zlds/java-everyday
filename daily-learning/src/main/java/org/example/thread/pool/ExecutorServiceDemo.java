package org.example.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: hanchaowei
 * @date 2024/1/28
 * @description:
 */

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<?> future1 = executorService.submit(() -> System.out.println("task 1"));
		Future<?> future2 = executorService.submit(() -> System.out.println("task 2"));
		Future<?> future13 = executorService.submit(() -> System.out.println("task 3"));
		executorService.shutdown();
	}
}

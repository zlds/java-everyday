package org.example.thread.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author: hanchaowei
 * @date 2024/1/28
 * @description:
 */

public class ExecutorDemo {
	public static void main(String[] args) {
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			System.out.println("task 1");
		});
		executor.execute(() -> {
			System.out.println("task 2");
		});
		executor.execute(() -> {
			System.out.println("task 3");
		});
	}

}

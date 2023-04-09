package org.example.redisson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: hanchaowei
 * @date 2023/4/9
 * @description:
 */

public class CounterTest {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<CounterRunnable> tasks = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			tasks.add(new CounterRunnable(counter));
		}

		// 执行任务
		for (CounterRunnable task : tasks) {
			executorService.submit(task);
		}

		executorService.shutdown();
		while (!executorService.isTerminated()) {
			Thread.sleep(1000);
		}

		System.out.println("Final counter value: " + counter.getValue());
		counter.close();
	}






















}

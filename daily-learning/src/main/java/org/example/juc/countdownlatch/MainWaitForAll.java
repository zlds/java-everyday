package org.example.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author: hanchaowei
 * @date 2023/4/11
 * @description: 主线程等待子线程全部执行完毕
 */

public class MainWaitForAll {

	/**
	 * 创建一个CountDownLatch实例，并设置计数器值为3,接着创建3个线程，每个线程执行完任务后，计数器减1，当计数器值为0时，表示所有任务都已完成。
	 * 在主线程中通过countDownLatch.await()方法，等待所有任务完成。
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建实例，设置计数器值为3
		CountDownLatch countDownLatch = new CountDownLatch(3);

		// 创建3个线程
		for (int i = 1; i <= 3 ; i++) {
			final int taskId = i;
			new Thread(() -> {
				System.out.println("Task " + taskId + " is running.");
				try {
					Thread.sleep((4 - taskId) * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Task " + taskId + " is finished.");
				// 完成任务，计数器减1
				countDownLatch.countDown();
			}).start();
		}

		System.out.println("Waiting for tasks to finish.....");

		try {
			// 等待所有任务完成
			countDownLatch.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("All tasks are finished.");
	}
}

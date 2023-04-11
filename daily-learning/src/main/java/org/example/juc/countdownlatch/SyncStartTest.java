package org.example.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author: hanchaowei
 * @date 2023/4/11
 * @description: 多线程同步启动
 */

public class SyncStartTest {
	/**
	 * 每个线程在启动后，调用countDownLatch.await()方法等待主线程的通知。当主线程完成准备工作后，调用countDownLatch.countDown()方法
	 * 所有等待的线程将同时开始执行。
	 * @param args
	 */

	public static void main(String[] args) {
		int numberOfThreads = 5;
		CountDownLatch countDownLatch = new CountDownLatch(1);

		for (int i = 0; i <= numberOfThreads; i++) {
			final int taskId = i;
			new Thread(() -> {
				System.out.println("Task " + taskId + " is ready");
				try {
					countDownLatch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Task " + taskId + " is running");
			}).start();
		}

		try {
			// 模拟主线程准备工作
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("通知所有等待线程，开始执行");
		// 释放所有等待的线程
		countDownLatch.countDown();
	}


}

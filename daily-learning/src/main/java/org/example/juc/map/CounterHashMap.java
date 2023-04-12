package org.example.juc.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author: hanchaowei
 * @date 2023/4/12
 * @description:
 */

public class CounterHashMap {

	/**
	 * HashMap是一个非线程安全的数据结构，我们创建10个线程，每个线程对map中的key为example的value进行100次自增操作，最后输出最终的结果。
	 */

	// 定义线程的数量
	private static final int THREAD_COUNT = 10;
	// 定义map
	private static Map<String,Integer> map = new HashMap<>();

	public static void increase(String key) {
		Integer count = map.get(key);
		if (count == null) {
			count = 1;
		} else {
			count = count + 1;
		}
		map.put(key, count);
	}


	public static void main(String[] args) {
		/**
		 * 初始化计数器设为1，作用是确保所有线程在同一时刻开始执行，当主线程调用startLatch.countDown()方法后，所有等待的线程将同时开始执行。
		 */
		CountDownLatch startLatch = new CountDownLatch(1);
		/**
		 * 作用是等待所有子线程执行完毕。每个子线程执行完毕后都会调用endLatch.countDown()方法，当endLatch的计数器为0时，表示所有子线程都执行完毕。
		 */
		CountDownLatch endLatch = new CountDownLatch(THREAD_COUNT);

		for (int i = 0; i < THREAD_COUNT; i++) {
			Thread thread = new Thread(() -> {
				try {
					startLatch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int j = 0; j < 100; j++) {
					increase("example");
				}
				endLatch.countDown();
			});
			thread.start();
		}
		// 开始执行所有线程
		startLatch.countDown();
		// 等待所有线程完成
		try {
			endLatch.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Final count: " + map.get("example"));
	}


}

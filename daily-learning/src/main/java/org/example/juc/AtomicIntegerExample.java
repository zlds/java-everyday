package org.example.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: hanchaowei
 * @date 2024/2/3
 * @description:
 */

public class AtomicIntegerExample {

	AtomicInteger atomicInteger = new AtomicInteger(0);
	// 递增并返回新值
	public int incrementAndGet() {
		return atomicInteger.incrementAndGet();
	}
	// 获取当前值
	public int getCount() {
		return atomicInteger.get();
	}

	public static void main(String[] args) throws InterruptedException {
		AtomicIntegerExample count = new AtomicIntegerExample();
		Thread[] threads = new Thread[100];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				for (int j = 0; j < 100; j++) {
					count.incrementAndGet();
				}
			});
			threads[i].start();
		}
		// 等待所有线程完成
		for (Thread t : threads) {
			t.join();
		}
		System.out.println("任务执行完成count = " + count.getCount());
	}
}

package org.example.thread;


/**
 * @author: hanchaowei
 * @date 2023/4/11
 * @description:
 */

public class BlockedStateDemo {
	private static final Object lock = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(BlockedStateDemo::criticalSection);
		Thread t2 = new Thread(BlockedStateDemo::criticalSection);

		/**
		 * 启动第一个线程，获取锁
		 * 加上Thread.sleep(100)是让主线程先暂停100毫秒，让t1线程先启动，保证t1先获取到锁。
		 * 因为线程的调度是操作系统管理的，具体哪个线程先执行是不确定的，即使我们按顺序启动线程，操作系统依然可能会以不同顺序执行他们。
		 * 可以将Thread.sleep(100)替换成CountDownLatch，更加严格控制。
		 */
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 启动第二个线程，尝试获取锁
		t2.start();


		// 打印线程状态
		System.out.println("t2线程状态 (BLOCKED): " + t2.getState());


	}

	/**
	 * 模拟锁
	 */
	private static void criticalSection() {
		synchronized (lock) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

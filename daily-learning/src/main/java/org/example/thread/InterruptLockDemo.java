package org.example.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2024/6/30
 * @description:
 */

public class InterruptLockDemo {

	private final static ReentrantLock LOCK = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		Thread threadOne = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("子线程启动");
					// 子线程获取锁
					LOCK.lockInterruptibly();
					System.out.println("子线程获取锁");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					LOCK.unlock();
				}
			}
		}, "THREAD-ONE");
		// main线程先获取锁
		LOCK.lock();
		// 启动子线程
		threadOne.start();
		// main休眠100ms
		Thread.sleep(100);
		threadOne.interrupt();
		LOCK.unlock();
	}
}

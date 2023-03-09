package org.example.juc.synch;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2023/3/9
 * @description:
 */

public class SemaphoreDemo {

	/**
	 * 假如有10个停车位
	 * acquire(获取) 当一个线程获取一个信号量(-1)，要么成功，要么阻塞，直到有一个信号量被释放
	 * release(释放) 释放一个信号量(加1)，然后唤醒等待的线程.
	 * 信号量主要用于两个目的,一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制
	 */

	public static void main(String[] args) {
		// 指定10个停车位
		Semaphore semaphore = new Semaphore(10);

		for (int i = 1; i <= 20; i++) {
			new Thread(() -> {
				try {
					// 抢车位
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + "抢到了车位.......");
					// 模拟停车时间，时间到了之后释放车位
					TimeUnit.SECONDS.sleep(3);
					System.out.println(Thread.currentThread().getName() + "停车3秒，离开了车位.......");

				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				} finally {
					semaphore.release();
				}
			},i +"").start();
		}
	}
}

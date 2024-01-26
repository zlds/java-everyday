package org.example.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author: hanchaowei
 * @date 2023/3/9
 * @description:
 */

public class CountDownLatchDemo {
	/**
	 * 设置一个数字，不断的循环减,当等于0时退出
	 * 线程调用await方法时，这些线程会阻塞
	 * 线程调用countDown方法时，数字减1
	 * 当计数器的值变为0时，因调用await方法而在等待的线程会被唤醒，继续执行
	 */
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(10);
		/**
		 * 模拟10个同学上自习，当发现没人在时班长关门
		 */
		for (int i = 0; i < 20; i++) {
			System.out.println("同学"+ i + "离开了教师");
			countDownLatch.countDown();
		}
		countDownLatch.await();
		System.out.println("班长关门了");
	}
}

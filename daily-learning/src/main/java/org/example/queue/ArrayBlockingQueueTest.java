package org.example.queue;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: hanchaowei
 * @date 2023/5/17
 * @description:
 */

public class ArrayBlockingQueueTest {
	public static void main(String[] args) {
		ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5);

		// 生产者
		new Thread (() -> {
			for (int i = 0; i < 10; i++) {
				try {
					arrayBlockingQueue.put(i);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				System.out.println("生产者生产了：" + i + " 当前时间: " + new Date());
			}
			System.out.println("生产者生产完毕。当前生产者大小：" + arrayBlockingQueue.size() + " 当前时间: " + new Date());
		}).start();

		// 消费者
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (!arrayBlockingQueue.isEmpty()) {
					try {
						arrayBlockingQueue.take();
						System.out.println("消费者消费了：" + i + " 当前时间: " + new Date());
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}).start();
	}
}

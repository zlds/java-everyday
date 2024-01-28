package org.example.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: hanchaowei
 * @date 2024/1/28
 * @description: 有界队列
 */

public class BoundedQueueExample {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

		// 生产者线程
		new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				try {
					queue.put(String.valueOf(i));
					System.out.println("生产者生产Item " + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		// 消费者线程
		new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				try {
					String item = queue.take();
					System.out.println("消费者消费Item " + item);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}















}

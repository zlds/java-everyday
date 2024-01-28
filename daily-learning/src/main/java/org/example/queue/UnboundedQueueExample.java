package org.example.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: hanchaowei
 * @date 2024/1/28
 * @description: 无界队列
 */

public class UnboundedQueueExample {

	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

		// 生产者
		new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				queue.offer(String.valueOf(i));
				System.out.println("生产者生产Item " + i);
			}
		}).start();

		// 消费者
		new Thread(() -> {
			while (true) {
				String item = queue.poll();
				if (item != null) {
					System.out.println("消费者消费Item " + item);
				}
			}
		}).start();
	}

}

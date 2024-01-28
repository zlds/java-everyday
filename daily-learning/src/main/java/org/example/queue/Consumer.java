package org.example.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author: hanchaowei
 * @date 2024/1/28
 * @description:
 */

public class Consumer implements Runnable {

	private final BlockingQueue<String> q ;

	public Consumer(BlockingQueue<String> q) {
		this.q = q;
	}

	@Override
	public void run() {
		try {
			while (true) {
				consume(q.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void consume(String x) {
		System.out.println("消费到了数据: " + x);
	}
}

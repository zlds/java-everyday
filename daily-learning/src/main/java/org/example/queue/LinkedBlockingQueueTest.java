package org.example.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: hanchaowei
 * @date 2023/5/18
 * @description:
 */

public class LinkedBlockingQueueTest {
	public static void main(String[] args) {
		LinkedBlockingQueue queue = new LinkedBlockingQueue();
		queue.offer("Java");
		queue.offer("Python");
		queue.offer("Go");

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

	}
}

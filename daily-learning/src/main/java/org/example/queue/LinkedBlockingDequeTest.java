package org.example.queue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: hanchaowei
 * @date 2023/5/18
 * @description: 双端队列
 */

public class LinkedBlockingDequeTest {
	public static void main(String[] args) {
		LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque<>();
		linkedBlockingDeque.offer("Python");
		// 从队头插入
		linkedBlockingDeque.offerFirst("Java");
		// 从队尾插入
		linkedBlockingDeque.offerLast("Go");

		while (!linkedBlockingDeque.isEmpty()) {
			System.out.println(linkedBlockingDeque.poll());
		}
	}
}

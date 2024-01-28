package org.example.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: hanchaowei
 * @date 2024/1/28
 * @description:
 */

public class ArrayBlockingQueueDemo {
	public static void main(String[] args) {
		// 指定容量大小(有界)
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}

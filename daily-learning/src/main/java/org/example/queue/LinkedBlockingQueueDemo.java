package org.example.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: hanchaowei
 * @date 2024/1/28
 * @description:
 */

public class LinkedBlockingQueueDemo {

	public static void main(String[] args) {
		// 不指定容量大小(无界)
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}

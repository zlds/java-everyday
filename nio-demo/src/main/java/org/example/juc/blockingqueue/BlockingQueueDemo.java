package org.example.juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2023/3/9
 * @description:
 */

public class BlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
//		add(blockingQueue);
//		offer(blockingQueue);
//		put(blockingQueue);
		outOfTime(blockingQueue);
	}

	public static void add(BlockingQueue<String> blockingQueue) {
		blockingQueue.add("a");
		blockingQueue.add("b");
		blockingQueue.add("c");

		// 参看队首值
		System.out.println("队首值: " + blockingQueue.element());
		// 取值
		System.out.println("第一个元素: " + blockingQueue.remove());
		System.out.println("第二个元素: " + blockingQueue.remove());
		System.out.println("第三个元素: " + blockingQueue.remove());
	}

	public static void offer(BlockingQueue<String> blockingQueue) {
		// 返回布尔值
		System.out.println(blockingQueue.offer("a"));
		System.out.println(blockingQueue.offer("b"));
		System.out.println(blockingQueue.offer("c"));
		// 队列满时不会报错
		System.out.println(blockingQueue.offer("d"));

	}

	public static void put(BlockingQueue<String> blockingQueue) throws InterruptedException {
		// 阻塞方法
		blockingQueue.put("a");
		blockingQueue.put("b");
		blockingQueue.put("c");
		// 执行时会阻塞
		blockingQueue.put("d");
	}

	public static void outOfTime(BlockingQueue<String> blockingQueue) throws InterruptedException {
		System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("b", 2, TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("c", 2, TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("c", 2, TimeUnit.SECONDS));
	}
}

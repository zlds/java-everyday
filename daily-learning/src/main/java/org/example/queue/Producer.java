package org.example.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author: hanchaowei
 * @date 2024/1/28
 * @description:
 */

public class Producer implements Runnable {

	private final BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}


	@Override
	public void run() {
		try {
			while (true) {
				queue.put(produce());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	String produce() {
		return "Log message";
	}












}

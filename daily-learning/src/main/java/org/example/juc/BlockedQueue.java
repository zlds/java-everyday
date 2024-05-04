package org.example.juc;


import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2024/5/3
 * @description: 通过ReentrantLock和Condition实现一个阻塞队列
 */

public class BlockedQueue<T> {

	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	final LinkedList<T> queue = new LinkedList<>();
	final int capacity = 10;

	/**
	 * 入队
	 * @param x
	 * @throws InterruptedException
	 */
	void enq(T x) throws InterruptedException{
		lock.lock();
		try {
			while (queue.size() == capacity) {
				// 等待队列不满
				notFull.await();
			}
			queue.add(x);
			// 入队后，通知可出队
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}


	T deq() throws InterruptedException {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				// 等待队列不空
				notEmpty.await();
			}
			T item = queue.poll();
			// 出队后通知可以入队
			notFull.signal();
			return item;
		} finally {
			lock.unlock();
		}

	}


	public static void main(String[] args) {
		BlockedQueue<Integer> blockedQueue = new BlockedQueue<>();
		new Thread(() -> {
			try {
				for (int i = 0; i < 20; i++) {
					blockedQueue.enq(i);
					System.out.println("入队：" + i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				for (int i = 0; i < 20; i++) {
					Integer deq = blockedQueue.deq();
					System.out.println("出队：" + deq);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}

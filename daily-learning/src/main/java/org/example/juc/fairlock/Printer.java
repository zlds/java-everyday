package org.example.juc.fairlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2023/7/30
 * @description: 打印任务(公平锁)
 */

public class Printer {


	// 公平锁
	private final ReentrantLock lock = new ReentrantLock(true);


	public void print(String job) {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " 正在打印：" + job);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

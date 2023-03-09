package org.example.juc.blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2023/3/9
 * @description:
 */

class SteamedBun {
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	// 馒头数量
	int num = 0;

	// 生产馒头
	public void  createSteamedBun() throws InterruptedException {
		lock.lock();
		try {
			// 如果有馒头就不生产
			while (num != 0) {
				condition.await();
			}
			num++;
			System.out.println(Thread.currentThread().getName() + "生产了第" + num + "个馒头");
			// 通知对方有馒头了
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	// 买馒头
	public void buySteamedBan() throws InterruptedException {
		lock.lock();
		try {
			// 如果没有馒头就等待
			while (num == 0) {
				condition.await();
			}
			// 如果有馒头就开买
			num--;
			System.out.println(Thread.currentThread().getName() + "买了第" + num + "个馒头");
			// 通知对方没馒头了
			condition.signalAll();
		} finally {
			lock.unlock();
		}


 	}
}
public class ConsumerProductDemo {
	public static void main(String[] args) {
		SteamedBun steamedBun = new SteamedBun();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					steamedBun.createSteamedBun();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "师傅").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					steamedBun.buySteamedBan();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "顾客").start();
	}
}

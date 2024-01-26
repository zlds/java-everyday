package org.example.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2023/3/10
 * @description:
 */

class SemaphoreDemo1 {

	Lock lock = new ReentrantLock();
	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();
	Condition c3 = lock.newCondition();

	/**
	 * 用于表示状态: 1:A 2:B 3:C
	 */
	int state = 1;

	/**
	 * A方法打印5次
	 */
	public void printA() {
		lock.lock();
		try {
			// 判断
			if (state != 1) {
				c1.await();
			}
			// 干活
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" +i);
			}
			// 通知B
			state = 2;
			c2.signal();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			lock.unlock();
		}
	}

	/**
	 * B方法打印10次
	 */
	public void printB() {
		lock.lock();
		try {
			// 判断
			if (state != 2) {
				c2.await();
			}
			// 干活
			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" +i);
			}
			// 通知B
			state = 3;
			c3.signal();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			lock.unlock();
		}
	}

	/**
	 * B方法打印15次
	 */
	public void printC() {
		lock.lock();
		try {
			// 判断
			if (state != 3) {
				c3.await();
			}
			// 干活
			for (int i = 1; i <= 15; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" +i);
			}
			// 通知a
			state = 1;
			c1.signal();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			lock.unlock();
		}
	}

}

public class ConditionDemo {

	/**
	 * 多线程之间按顺序，实现A->B>C
	 * 条件如下:
	 * A打印5次，B打印10次，C打印15次
	 * @param args
	 */
	public static void main(String[] args) {
		SemaphoreDemo1 semaphoreDemo1 = new SemaphoreDemo1();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				semaphoreDemo1.printA();
			}
		},"A").start();

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				semaphoreDemo1.printB();
			}
		},"B").start();

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				semaphoreDemo1.printC();
			}
		},"C").start();

	}
}

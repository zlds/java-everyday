package org.example.juc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2023/8/13
 * @description: 可重入锁
 */

public class ReentrancyTest {

	private final ReentrantLock lock = new ReentrantLock();

	public void method1() {
		lock.lock();
		try {
			// 业务逻辑
			System.out.println("我是method1方法哦...... " + Thread.currentThread().getName());
			// 再次调用了一个获取锁的方法
			method2();
		} finally {
			lock.unlock();
		}
	}

	public void method2() {
		lock.lock();
		try {
			// 业务逻辑
			System.out.println("我是method2方法哦..... " + Thread.currentThread().getName());
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ReentrancyTest reentrancyTest = new ReentrancyTest();
		Thread t1 = new Thread(() -> {
			reentrancyTest.method1();
		});
		Thread t2 = new Thread(() -> {
			reentrancyTest.method1();
		});
		t1.start();
		t2.start();
	}

}

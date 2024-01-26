package org.example.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2023/3/8
 * @description:
 */

class PhonePlus {
	public synchronized void sendEmail() {
		System.out.println(Thread.currentThread().getName() + "==== sendEMail.....");
		sendMessage();
	}
	public synchronized void sendMessage() {
		System.out.println(Thread.currentThread().getName() + "==== sendMessage.....");
	}


	ReentrantLock lock = new ReentrantLock();
	public void method1() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "==== method1.....");
			method2();
		} finally {
			lock.unlock();
		}
	}
	public void method2() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "==== method2.....");
		} finally {
			lock.unlock();
		}
	}

}
public class ReentrantLockDemo {
	public static void main(String[] args) {
		PhonePlus phone = new PhonePlus();
		new Thread(() -> {
			phone.method1();
		},"A").start();
		new Thread(() -> {
			phone.method1();
		},"B").start();
	}
}

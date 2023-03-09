package org.example.juc.synch;

import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2023/3/8
 * @description:
 */

public class LockDemo {

	public static void main(String[] args) {
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		/**
		 * A线程先发送邮件
		 * B线程发送短信
		 */
		new Thread(() -> {
			phone1.sendEmail();
		},Thread.currentThread().getName()).start();

		new Thread(() -> {
			phone2.sendMessage();
		},Thread.currentThread().getName()).start();
	}
}

class Phone {
	public static synchronized void sendEmail() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("sendEmail");
	}

	public static synchronized void sendMessage() {
		System.out.println("sendMessage");
	}
}

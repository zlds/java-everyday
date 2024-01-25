package org.example.thread;

/**
 * @author: hanchaowei
 * @date 2024/1/25
 * @description: 死锁示例
 */

public class DeadlockDemo {

	public static void main(String[] args) {
		String data1 = "data1";
		String data2 = "data2";

		// 线程1尝试锁定资源1,然后在锁定资源2
		Thread t1 = new Thread(() -> {
			synchronized (data1) {
				System.out.println("t1线程,锁定data1资源");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (data2) {
					System.out.println("t1线程,锁定data2资源");
				}
			}
		});

		// 线程2尝试锁定资源2,然后在锁定资源1
		Thread t2 = new Thread(() -> {
			synchronized (data2) {
				System.out.println("t2线程,锁定data2资源");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}

				synchronized (data1) {
					System.out.println("t2线程,锁定data1资源");
				}
			}
		});

		t1.start();
		t2.start();
	}
}

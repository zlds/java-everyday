package org.example.thread;

/**
 * @author: hanchaowei
 * @date 2024/6/29
 * @description:
 */

public class InterruptSleepDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread threadOne = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("子线程启动");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("子线程结束");
			}
		}, "THREAD-ONE");
		threadOne.start();
		Thread.sleep(100);
		threadOne.interrupt();
	}
}

package org.example.thread;

/**
 * @author: hanchaowei
 * @date 2024/6/29
 * @description: 中断正在运行的线程示例
 */

public class InterruptDemo {

	public static void main(String[] args) throws InterruptedException {
		// 中断正在运行的线程并不会立即停止线程，而是给线程发送一个中断信号，线程可以忽略这个信号。
		Thread threadOne = new Thread(new Runnable() {
			@Override
			public void run() {
				for (; ; ) {
					System.out.println("我是thredOne线程，我的中断状态是:" + Thread.currentThread().isInterrupted());
				}
			}
		}, "THREAD-ONE");
		// 启动子线程
		threadOne.start();
		// 主线程暂停1s
		Thread.sleep(1000);
		// 中断子线程
		threadOne.interrupt();
	}
}

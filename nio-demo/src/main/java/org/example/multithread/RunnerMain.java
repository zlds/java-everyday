package org.example.multithread;

/**
 * @author: hanchaowei
 * @date 2023/3/11
 * @description:
 */

public class RunnerMain {
	public static void main(String[] args) throws InterruptedException {
		Runner1 runner1 = new Runner1();
		Thread thread1 = new Thread(runner1);
		thread1.start();

		Runner2 runner2 = new Runner2();
		Thread thread2 = new Thread(runner2);
		thread2.setName("thread2");
		thread2.start();
		thread2.interrupt();

		System.out.println(Thread.activeCount());
	}
}

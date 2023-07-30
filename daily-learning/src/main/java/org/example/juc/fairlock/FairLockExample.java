package org.example.juc.fairlock;

/**
 * @author: hanchaowei
 * @date 2023/7/30
 * @description:
 */

public class FairLockExample {
	public static void main(String[] args) {
		Printer printer = new Printer();
		Thread thread1 = new Thread(() -> printer.print("job1"));
		Thread thread2 = new Thread(() -> printer.print("job2"));
		Thread thread3 = new Thread(() -> printer.print("job3"));

		thread1.start();
		thread2.start();
		thread3.start();
	}
}

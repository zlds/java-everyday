package org.example.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * @author: hanchaowei
 * @date 2023/3/21
 * @description:
 */

public class SemaphoreTest {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

	public static void print(Semaphore semaphore) {
		System.out.println(sdf.format(new Date()) + " " + Thread.currentThread().getName() +"\t" + semaphore.toString());
	}


	public static void main(String[] args) throws InterruptedException {
		// 定义5个信号量
		Semaphore semaphore = new Semaphore(5);
		// 申请4个,并打印剩余信号量
		semaphore.acquire(4);
		print(semaphore);

		Thread thread = new Thread(() -> {
			try {
				print(semaphore);
				// 阻塞等待
				semaphore.acquire(2);
				print(semaphore);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		// 休息5秒，释放一个信号量
		thread.start();
		Thread.sleep(5000);
		// 释放一个信号量
//		semaphore.release(1);
		// 模拟中断
		thread.interrupt();
		Thread.sleep(1000);
		print(semaphore);
	}
}

package org.example.juc.synch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: hanchaowei
 * @date 2023/3/8
 * @description:
 */

class WC {
	AtomicReference<Thread> atomicReference = new AtomicReference<>();

	// 锁门
	public void lock() throws InterruptedException {
		Thread thread = Thread.currentThread();
		// 如果为null说明里面没人,否则自旋重试
		while (!atomicReference.compareAndSet(null,thread)) {
			System.out.println(thread.getName() + "=====等待中....");
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println(thread.getName() + "=====在卫生间中....");
	}
	// 开门(出来)
	public void unlock() {
		Thread thread = Thread.currentThread();
		// 如果是当前线程,则开门(期望值是thread当前线程,预期是null）
		atomicReference.compareAndSet(thread,null);
		System.out.println(thread.getName() + "=====出来了");
	}
}
public class SpinLockDemo {
	public static void main(String[] args) {
		WC wc = new WC();

		new Thread(() -> {
			try {
				wc.lock();
				TimeUnit.SECONDS.sleep(3);
				wc.unlock();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		},"A").start();


		new Thread(() -> {

			try {
				wc.lock();
				TimeUnit.SECONDS.sleep(5);
				wc.unlock();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		},"B").start();
	}
}

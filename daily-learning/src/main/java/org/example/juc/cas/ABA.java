package org.example.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: hanchaowei
 * @date 2023/3/7
 * @description: CAS ABA问题
 */

public class ABA {
	public static void main(String[] args) {
		/**
		 *  ABA问题演示
		 *  用两个线程模拟
		 */
		AtomicReference<Integer> integerAtomicReference = new AtomicReference<>(100);
		new Thread(() -> {
			System.out.println("我是" + Thread.currentThread().getName() + "线程" + " 我先休眠2秒在修改数据");
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("我是线程"+ Thread.currentThread().getName() +"休眠之后我要将数据修改为2000: "+ integerAtomicReference.compareAndSet(100, 2000));
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		},"t1").start();

		new Thread(() -> {
			System.out.println("我是线程" + Thread.currentThread().getName() + "我要将数据修改为:101，" + integerAtomicReference.compareAndSet(100, 101));

			System.out.println("我是线程" + Thread.currentThread().getName() + "我要将数据修改为:100，" + integerAtomicReference.compareAndSet(101, 100));
		},"t2").start();

		/**
		 * ABA问题解决
		 * 通过时间戳解决
		 * 参数: 预期的值，新的值，预期值的版本号，新值的版本号(预期值版本+1)
		 */

		AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);
		new Thread(() -> {
			int stamp = atomicStampedReference.getStamp();
			System.out.println("我是" + Thread.currentThread().getName() + "线程" + " 我先休眠2秒在修改数据");
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("休眠之后的版本值" + atomicStampedReference.getStamp());
				System.out.println("我是线程"+ Thread.currentThread().getName() +"休眠之后我要将数据修改为2000: "+ atomicStampedReference.compareAndSet(100, 2000, stamp, atomicStampedReference.getStamp() + 1));
				System.out.println("t3修改之后的值" + atomicStampedReference.getReference());
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		},"t3").start();

		new Thread(() -> {
			int stamp = atomicStampedReference.getStamp();
			System.out.println("我是线程" + Thread.currentThread().getName() + "我要将数据修改为:101，" + atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1));

			System.out.println("我是线程" + Thread.currentThread().getName() + "我要将数据修改为:100，" + atomicStampedReference.compareAndSet(101, 100, stamp + 1, stamp + 2));
		},"t4").start();

	}
}

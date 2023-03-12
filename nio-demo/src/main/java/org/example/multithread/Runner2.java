package org.example.multithread;

/**
 * @author: hanchaowei
 * @date 2023/3/11
 * @description:
 */

public class Runner2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("进入Runner2运行状态——————————" + i);
		}
		// 查看线程是否中断,如果线程已被中断返回true，否则返回false
		System.out.println(Thread.currentThread().getName() +  "线程中断状态: " + Thread.currentThread().isInterrupted());

		// 设置中断
		boolean interrupted1 = Thread.interrupted();
		System.out.println("设置" + Thread.currentThread().getName() + "线程中断返回结果: " + interrupted1);

		// 设置中断后打印
		System.out.println("线程"  + Thread.currentThread().getName() +  "设置中断后状态: " + Thread.currentThread().isInterrupted());

	}
}

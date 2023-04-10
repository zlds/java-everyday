package org.example.thread;

/**
 * @author: hanchaowei
 * @date 2023/4/10
 * @description: 线程状态切换
 */

public class ThreadStateDemo {
	/**
	 * NEW：线程刚创建，但尚未启动。
	 * RUNNABLE：线程正在运行或等待操作系统资源，如CPU时间片。
	 * BLOCKED：线程在等待锁释放，以便进入同步代码块。(该状态不会占用cpu资源，但是会占用内存资源。当锁被释放时，jvm会通知操作系统，操作系统线程调度器
	 * 会将等待这个锁的线程，将他们从BLOCKED状态变成可运行状态)
	 * WAITING：线程处于无限期等待状态，等待其他线程通过notify()或notifyAll()方法发出通知。
	 * TIMED_WAITING：线程处于有限期等待状态，等待其他线程通过notify()或notifyAll()方法发出通知或等待时间到达。
	 * TERMINATED：线程执行完成或终止。
	 */
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			try {
				// 当前线程处于RUNNABLE状态
				System.out.println("线程正在运行...." + Thread.currentThread().getState());
				// 让线程进入TIME_WAITING状态,等待2000毫秒
				Thread.sleep(2000);
				// 线程重新进入RUNNABLE状态
				System.out.println("线程等待结束，继续执行.....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		// 初始化线程处于NEW状态
		System.out.println("线程状态(NEW): " + thread.getState());
		// 调用start方法，线程进入RUNNABLE状态
		thread.start();
		System.out.println("启动线程，线程状态(RUNNABLE): " + thread.getState());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		// 线程执行完毕,处于TERMINATED状态
		System.out.println("线程状态(TERMINATED)：" + thread.getState());
	}
}

package org.example.thread;



import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2024/7/13
 * @description: InheritableThreadLocal 创建子线程时,复制父线程的本地变量。
 */

public class InheritableThreadLocalExample {


//	private static  ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
	// 支持拷贝
	private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();


	public static void main(String[] args) throws InterruptedException {
		// 父线程设置值
		threadLocal.set(123);
		System.out.println("父线程获取到的值:" + threadLocal.get());
		// 子线程获取值
		new Thread(() -> {
			System.out.println("子线程获取到的值:" + threadLocal.get());
		}).start();
		TimeUnit.SECONDS.sleep(1);
	}

}

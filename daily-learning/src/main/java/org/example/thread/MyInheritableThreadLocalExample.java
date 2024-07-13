package org.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2024/7/13
 * @description: InheritableThreadLocal 创建子线程时,复制父线程的本地变量。
 */

public class MyInheritableThreadLocalExample {

	// 引用类型(非线程安全)
//	private static ThreadLocal<User> threadLocal = new InheritableThreadLocal<>();

	// 线程安全
	private static ThreadLocal<User> threadLocal = new MyInheritableThreadLocal<>();


	private static ExecutorService executorService =  Executors.newFixedThreadPool(1);
	public static void main(String[] args) throws InterruptedException {
		threadLocal.set(new User("user1",18));
		executorService.submit(() -> {
			System.out.println("子线程获取到的值:" + threadLocal.get());
			threadLocal.get().setAge(20);
			System.out.println("子线程修改值:" + threadLocal.get());
		});
		TimeUnit.SECONDS.sleep(1);
		System.out.println("父线程获取值:" + threadLocal.get());
		threadLocal.get().setAge(28);
		System.out.println("父线程修改值:" + threadLocal.get());
		executorService.submit(() -> {
			System.out.println("子线程获取到的值:" + threadLocal.get());
		});
		executorService.shutdown();

	}


	static class User {
		private String name;
		private Integer age;

		public User(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
		}
	}
}

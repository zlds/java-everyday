package org.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2024/7/13
 * @description:
 */

public class TransmittableThreadLocalExample {

	// 每次提交任务到线程池,都会拷贝父线程的本地变量(ITL是不会的)

	private static ThreadLocal<User> threadLocal = new MyInheritableThreadLocal<>();

	private static ExecutorService executors = Executors.newFixedThreadPool(1);

	public static void main(String[] args) throws InterruptedException {
		threadLocal.set(new User("张三", 18));
		System.out.println("主线程值:" + threadLocal.get());
		executors.submit(() -> {
			System.out.println("子线程读取本地变量:" + threadLocal.get());
		});
		TimeUnit.SECONDS.sleep(1);
		threadLocal.get().setAge(20);
		System.out.println("主线程修改了值:" + threadLocal.get());
		executors.submit(() -> {
			System.out.println("子线程读取本地变量:" + threadLocal.get());
		});

		executors.shutdown();

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
			return "User{" + "name='" + name + '\'' + ", age='" + age + '\'' + '}';
		}
	}
}

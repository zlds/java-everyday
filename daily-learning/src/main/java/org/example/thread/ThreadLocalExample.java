package org.example.thread;


/**
 * @author: hanchaowei
 * @date 2024/5/5
 * @description:
 */

public class ThreadLocalExample {

	// 存放当前线程的局部变量
	private static final ThreadLocal<User> userHolder = new ThreadLocal<>();

	// 设置当前线程的用户信息
	public static void setUser(User user) {
		userHolder.set(user);
	}
	// 获取当前线程的用户信息
	public static User getUser() {
		return userHolder.get();
	}
	// 清理当前线程的用户信息
	public static void clear() {
		userHolder.remove();
	}


	public static void main(String[] args) {
		// 为每个线程创建自己的用户数据
		new Thread(() -> {
			ThreadLocalExample.setUser(new User("user1"));
			System.out.println(ThreadLocalExample.getUser().getUsername());
			ThreadLocalExample.clear();
		}).start();

		new Thread(() -> {
			ThreadLocalExample.setUser(new User("user2"));
			System.out.println(ThreadLocalExample.getUser().getUsername());
			ThreadLocalExample.clear();
		}).start();

		new Thread(() -> {
			ThreadLocalExample.setUser(new User("user3"));
			System.out.println(ThreadLocalExample.getUser().getUsername());
			ThreadLocalExample.clear();
		}).start();

	}






	static class User {
		private String username;
		public User(String username) {
			this.username = username;
		}
		public String getUsername() {
			return username;
		}
	}
}

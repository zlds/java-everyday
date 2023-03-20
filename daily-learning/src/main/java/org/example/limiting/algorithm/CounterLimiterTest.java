package org.example.limiting.algorithm;

/**
 * @author: hanchaowei
 * @date 2023/3/20
 * @description:
 */

public class CounterLimiterTest {
	public static void main(String[] args) {
		CounterLimiter counterLimiter = new CounterLimiter();
		// 模拟10个并发请求，最终只有5个成功
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				if (counterLimiter.tryAcquire()) {
					System.out.println(Thread.currentThread().getName() + "请求成功");
				} else {
					System.out.println(Thread.currentThread().getName() + "请求失败");
				}
			}).start();
		}
	}
}

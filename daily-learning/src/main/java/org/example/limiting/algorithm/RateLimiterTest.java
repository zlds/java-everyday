package org.example.limiting.algorithm;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2023/3/22
 * @description:
 */

public class RateLimiterTest {
	public static void main(String[] args) throws InterruptedException {
		// 每秒限制2个请求
		RateLimiter rateLimiter = RateLimiter.create(2.0);
		// 模拟请求
		for (int i = 0; i < 10; i++) {
			// 尝试获取许可
			if (rateLimiter.tryAcquire(1)) {
				System.out.println("请求成功 " + i);
			} else {
				System.out.println("被限流了 " + i);
			}
		}
	}
}

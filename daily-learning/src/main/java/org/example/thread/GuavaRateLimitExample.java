package org.example.thread;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: hanchaowei
 * @date 2024/5/10
 * @description: Guava限流器入门示例
 */

public class GuavaRateLimitExample {

	public static void main(String[] args) {
		// 限流器,每秒产生2个令牌
		RateLimiter rateLimiter = RateLimiter.create(2.0);
		ExecutorService es = Executors.newFixedThreadPool(1);
		final long startTime = System.currentTimeMillis();
		for (int i = 0; i < 20; i++) {
			// 获取令牌
			rateLimiter.acquire();
			// 提交任务异步执行
			es.execute(() -> {
				long currentTime = System.currentTimeMillis();
				// 纳秒转换为毫秒
				double elapsedMillis = (currentTime - startTime) / 1000.0;
				System.out.println("经过时间：" + elapsedMillis + " 秒");
			});
		}
		es.shutdown();

	}
}

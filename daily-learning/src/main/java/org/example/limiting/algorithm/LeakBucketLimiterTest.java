package org.example.limiting.algorithm;

/**
 * @author: hanchaowei
 * @date 2023/3/21
 * @description:
 */

public class LeakBucketLimiterTest {
	public static void main(String[] args) {
		LeakBucketLimiter leakBucketLimiter = new LeakBucketLimiter(10,5);
		for (int i = 0; i < 100; i++) {
			if (leakBucketLimiter.acquire()) {
				System.out.println("get token");
			} else {
				System.out.println("not get token");
			}
		}
	}
}

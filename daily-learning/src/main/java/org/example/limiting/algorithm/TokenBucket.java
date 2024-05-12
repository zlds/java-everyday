package org.example.limiting.algorithm;

/**
 * @author: hanchaowei
 * @date 2024/5/12
 * @description: 令牌桶算法
 */

public class TokenBucket {

	// 下一个令牌的可用时间
	private long nextAvailableTime;
	// 产生令牌的间隔时间(毫秒单位)
	private long rateToMs;

	public TokenBucket(long startTime, long rateToMs) {
		this.nextAvailableTime = startTime;
		this.rateToMs = rateToMs;
	}

	public synchronized long reserve(long currentTime) {
		if (currentTime > nextAvailableTime) {
			// 如果当前时间大于下一个令牌的产生时间，重置令牌时间
			nextAvailableTime = currentTime;
		}
		// 返回令牌的产生时间
		long reservedTime = nextAvailableTime;
		// 计算下一个令牌的产生时间
		nextAvailableTime += rateToMs;
		return reservedTime;
	}

	public static void main(String[] args) {
		TokenBucket tokenBucket = new TokenBucket(System.currentTimeMillis(), 1000);
		for (int i = 0; i < 10; i++) {
			long currentTime = System.currentTimeMillis();
			long reservedTime = tokenBucket.reserve(currentTime);
			// 当当前时间 >= 保留的时间，表示已经到了或者超过了令牌应该被释放的时间
			if (currentTime >= reservedTime) {
				System.out.println("get token at: " + currentTime + " with reserved time: " + reservedTime);
			} else {
				System.out.println("wait for token, next token at: " + reservedTime);
				// 拒绝请求或者等待
			}
		}
	}
	

}

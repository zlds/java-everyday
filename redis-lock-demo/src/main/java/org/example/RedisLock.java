package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * @author: hanchaowei
 * @date 2023/3/18
 * @description:
 */

public class RedisLock {


	/**
	 * redis加上成功返回结果
	 */
	private static final String LOCK_SUCCESS = "OK";

	/**
	 * redis删除锁返回结果
	 */
	private static final long UNLOCK_SUCCESS = 1L;

	/**
	 * 获取分布式锁
	 */
	public static boolean tryLock(Jedis jedis, String lockKey, String requestId,int expireTime) {
		// 自旋锁,客户端B会一直循环等待客户端A释放锁
		while (true) {
			// nx只有键不存在的时候才会设置key，并且添加过期时间
			String result = jedis.set(lockKey, requestId, SetParams.setParams().ex(expireTime).nx());
			if (LOCK_SUCCESS.equals(result)) {
				return true;
			}
		}
	}

	/**
	 * 释放锁
	 */
	public static boolean unlock(Jedis jedis,String lockKey,String requestId) {
		// 防止释放他人的锁
		if (!requestId.equals(jedis.get(lockKey))) {
			return false;
		}
		Long result = jedis.del(lockKey);
		if (UNLOCK_SUCCESS == result) {
			return true;
		}
		return false;
	}


}

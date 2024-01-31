package org.example.cache;

import com.google.common.cache.CacheLoader;

/**
 * @author: hanchaowei
 * @date 2024/1/30
 * @description: 缓存加载器
 */

public class UserCacheLoader extends CacheLoader<Long, User> {

	@Override
	public User load(Long userId){
		// 加载用户信息的逻辑
		return new User(1L, "user" + userId,"BJ");
	}

}

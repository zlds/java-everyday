package org.example.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2023/9/21
 * @description: guava cache demo
 */

public class LoadingCacheDemo {

	public static void main(String[] args) throws ExecutionException {
		// lambda表达式测试
		LoadingCache<Long, User> cache = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.expireAfterWrite(10, TimeUnit.MINUTES)
				.build(new CacheLoader<Long, User>() {
					@Override
					public User load(Long key) throws Exception {
						return new User(2L, "user2","SH");
					}
				});
		User test1 = cache.get(1L);
		System.out.println("test1的id: " + test1.getId() + " ,test1的name: " + test1.getName());


		// UserCacheLoader测试
		LoadingCache<Long, User> userLoadingCache = CacheBuilder.newBuilder().build(new UserCacheLoader());
		User test2 = userLoadingCache.get(1L);
		System.out.println("test2的id: "+ test2.getId() + " ,test2的name: " + test2.getName());


		// 使用组合键
		LoadingCache<UserRegionKey, User> regionKeyUserLoadingCache = CacheBuilder.newBuilder()
				.build(new CacheLoader<UserRegionKey, User>() {
					@Override
					public User load(UserRegionKey userRegionKey) throws Exception {
						return new User(3L, "user3", "NJ");
					}
				});
		UserRegionKey userRegionKey = new UserRegionKey(2L, "BJ");
		User test3 = regionKeyUserLoadingCache.get(userRegionKey);
		System.out.println("test3的id: " + test3.getId() + " ,test3的name: " + test3.getName());
	}
}

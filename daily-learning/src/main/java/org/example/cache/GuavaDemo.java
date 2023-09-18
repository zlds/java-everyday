package org.example.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2023/9/18
 * @description:
 */

public class GuavaDemo {

	// 创建一个具体类型的Guava缓存对象
	private LoadingCache<String,String> cache = CacheBuilder.newBuilder()
			// 设置缓存的最大容量
			.maximumSize(1000)
			// 设置缓存的过期时间
			.expireAfterWrite(10,TimeUnit.MINUTES)
			.build(new CacheLoader<String,String>() {
				@Override
				public String load(String key) throws Exception {
					// 这里不需要实际的加载逻辑，因为我们是手动加载缓存的
					return null;
				}
			});


	public void setCache(String key,String value) {
		cache.put(key, value);
	}

	public String getCache(String key) {
		// 如果不存在返回null
		return cache.getIfPresent(key);
	}

	public static void main(String[] args) {
		GuavaDemo guavaDemo = new GuavaDemo();
		guavaDemo.setCache("1","1");
		guavaDemo.setCache("2","2");
		guavaDemo.setCache("3","3");
		System.out.println(guavaDemo.getCache("1"));
	}

}

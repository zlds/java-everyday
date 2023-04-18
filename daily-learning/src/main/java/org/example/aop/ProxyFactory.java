package org.example.aop;

import java.lang.reflect.Proxy;

/**
 * @author: hanchaowei
 * @date 2023/4/18
 * @description: 手动使用创建代理类
 */

public class ProxyFactory {
	/**
	 * 创建代理对象
	 * @param target
	 * @param interfaceType
	 * @return
	 * @param <T>
	 */
	public static <T> T createProxy(T target, Class<?> interfaceType) {
		LoggingInvocationHandler handler = new LoggingInvocationHandler(target);
		// 获取目标类的类加载器
		ClassLoader classLoader = target.getClass().getClassLoader();
		// 第二个获取目标类实现的所有接口
		// 第三个参数是InvocationHandler对象，该参数和回调有关系
		// 使用java反射API创建代理对象。
		return (T) Proxy.newProxyInstance(classLoader, new Class<?>[]{interfaceType}, handler);
	}
}

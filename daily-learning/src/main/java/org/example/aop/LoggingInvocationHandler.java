package org.example.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: hanchaowei
 * @date 2023/4/17
 * @description: 使用动态代理来实现AOP
 */

public class LoggingInvocationHandler implements InvocationHandler {
	// 要代理的目标对象
	private final Object target;

	public LoggingInvocationHandler(Object target) {
		this.target = target;
	}

	// 负责处理代理实例上的方法调用
	// proxy: 生成代理类实例，method: 被调用的方法，args: 调用目标对象时传递的参数

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("方法执行前获取请求信息: " + method.getName());
		// 调用目标方法
		Object result = method.invoke(target, args);
		System.out.println("方法请求后记录到db中: " + method.getName());
		return result;
	}
}

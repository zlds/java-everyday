package org.example.aop;

/**
 * @author: hanchaowei
 * @date 2023/4/18
 * @description:
 */

public class ProxyFactoryTest {
	public static void main(String[] args) {
		// 创建目标示例对象
		IMyAopService iMyAopService = new IMyAopServiceImpl();
		// 创建日志记录实例
		LoggingInvocationHandler loggingInvocationHandler = new LoggingInvocationHandler(iMyAopService);
		// 使用ProxyFactory创建代理对象
		IMyAopService proxy = ProxyFactory.createProxy(iMyAopService, IMyAopService.class);
		proxy.getMessage();

	}
}

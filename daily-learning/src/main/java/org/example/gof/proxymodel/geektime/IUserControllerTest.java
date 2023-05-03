package org.example.gof.proxymodel.geektime;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class IUserControllerTest {
	public static void main(String[] args) {
		/*
		因为原始类和代理类实现相同的接口，是基于接口而非实现编程
		将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码

		这就是面向接口的好处，只需要很少的改动。
		 */
		IUserController userControllerProxy = new UserControllerProxy(new UserController());
		userControllerProxy.login("123", "123");

		/**
		 * 假设我们有一个外部类，UserController，现在我们要扩展UserController，可以让代理类继承UserController，
		 * 实现扩展功能。
		 */
		UserControllerProxyExtend userControllerProxyExtend = new UserControllerProxyExtend();
		userControllerProxyExtend.login("123", "123");

		/**
		 * 高阶使用，通过动态代理实现。
		 * 为什么要通过动态代理：如果我们有50个要扩展功能的原始类，那我们就需要创建50个对应的代理类，这会导致项目中的类成倍增加，增加了代码维护成本。
		 * 动态代理的方式，只需要创建一个动态代理类，通过传入不同的原始类对象，就可以创建不同的动态代理类对象，这样就避免了创建过多的代理类。
		 */
		//MetricsCollectorProxy使用举例
		MetricsCollectorProxy proxy = new MetricsCollectorProxy();
		IUserController userController = (IUserController) proxy.createProxy(new UserController());

	}
}

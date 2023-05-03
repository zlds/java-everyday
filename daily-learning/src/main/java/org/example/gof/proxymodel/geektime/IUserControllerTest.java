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
	}
}

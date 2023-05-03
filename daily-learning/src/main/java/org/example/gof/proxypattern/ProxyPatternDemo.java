package org.example.gof.proxypattern;

import java.lang.reflect.Proxy;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public class ProxyPatternDemo {
	public static void main(String[] args) {
		Image image = (Image) Proxy.newProxyInstance(
				Image.class.getClassLoader(),
				new Class[]{Image.class},
				new ImageInvocationHandler("test.jpg")
		);

		image.display();
	}
}

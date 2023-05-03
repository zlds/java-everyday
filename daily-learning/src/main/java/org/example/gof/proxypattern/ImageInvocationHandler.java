package org.example.gof.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description: 动态代理
 */

public class ImageInvocationHandler implements InvocationHandler {
	private RealImage realImage;
	private String filename;


	public ImageInvocationHandler(String filename) {
		this.filename = filename;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (realImage == null) {
			realImage = new RealImage(filename);
		}
		System.out.println("方法开始执行前: " + method.getName());
		Object result = method.invoke(realImage, args);
		System.out.println("方法执行后: " + method.getName());
		return result;
	}
}

package org.example.gof.decoratorpattern.geektime;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class ADecorator implements IA {
	private A a;

	public ADecorator(A a) {
		this.a = a;
	}
	// 增强f方法

	@Override
	public void f() {
		System.out.println("增强f方法");
		a.f();
	}
}

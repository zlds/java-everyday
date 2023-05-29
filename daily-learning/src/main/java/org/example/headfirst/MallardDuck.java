package org.example.headfirst;

/**
 * @author: hanchaowei
 * @date 2023/5/29
 * @description:
 */

public class MallardDuck extends Duck {

	public MallardDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
		super(flyBehavior, quackBehavior);
	}

	@Override
	public void display() {
		System.out.println("我是绿头鸭");
	}
}

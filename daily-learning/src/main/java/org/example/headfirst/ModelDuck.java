package org.example.headfirst;

/**
 * @author: hanchaowei
 * @date 2023/5/29
 * @description:
 */

public class ModelDuck extends Duck {
	public ModelDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
		super(flyBehavior, quackBehavior);
	}

	@Override
	public void display() {
		System.out.println("我是模型鸭");
	}
}

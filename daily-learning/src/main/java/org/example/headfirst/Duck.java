package org.example.headfirst;

/**
 * @author: hanchaowei
 * @date 2023/5/29
 * @description: 鸭子行为接口类
 */

public abstract class Duck {

	/**
	 * 飞行行为
	 */
	private FlyBehavior flyBehavior;

	/**
	 * 叫声行为
	 */
	private QuackBehavior quackBehavior;

	public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
		this.flyBehavior = flyBehavior;
		this.quackBehavior = quackBehavior;
	}

	public abstract void display();

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float, even decoys");
	}

	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
}

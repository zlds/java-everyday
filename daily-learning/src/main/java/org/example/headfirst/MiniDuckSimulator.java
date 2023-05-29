package org.example.headfirst;

/**
 * @author: hanchaowei
 * @date 2023/5/29
 * @description: 这个案例中，是将变化的给抽离出来，通过组合的方式来应对变化。
 * 我们定义一个鸭子类，这个鸭子类有两个行为，一个是飞行行为，一个是叫声行为，这两个行为都是变化的，所以我们将其抽离出来，定义成接口。
 * 这些行为是可以互换。这样的好处是，如果有新的行为，我们只需要实现这个接口，然后将其组合到鸭子类中即可。
 * 总结: 多用组合，少用继承.
 */

public class MiniDuckSimulator {

	public static void main(String[] args) {
		Duck mallard = new MallardDuck(new FlyWithWings(),new Quack());
		mallard.performQuack();
		mallard.performFly();

		mallard.setFlyBehavior(new FlyRocketPowered());
		mallard.performFly();
	}
}

package org.example.headfirst;

/**
 * @author: hanchaowei
 * @date 2023/5/29
 * @description:
 */

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("我不会叫");
	}
}

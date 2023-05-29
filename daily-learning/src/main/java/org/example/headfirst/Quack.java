package org.example.headfirst;

/**
 * @author: hanchaowei
 * @date 2023/5/29
 * @description:
 */

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("呱呱叫");
	}
}

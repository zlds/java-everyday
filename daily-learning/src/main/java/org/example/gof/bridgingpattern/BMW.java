package org.example.gof.bridgingpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/22
 * @description:
 */

public class BMW implements Brand {

	@Override
	public void info() {
		System.out.println("宝马");
	}
}

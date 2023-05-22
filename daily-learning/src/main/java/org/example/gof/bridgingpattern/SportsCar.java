package org.example.gof.bridgingpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/22
 * @description: 跑车
 */

public class SportsCar extends Car {

	public SportsCar(Brand brand) {
		super(brand);
	}

	@Override
	public void info() {
		super.info();
		System.out.println("跑车");
	}
	public void convertible() {
		System.out.println("打开敞篷");
	}
}


package org.example.gof.bridgingpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/22
 * @description: 汽车抽象类
 */

public abstract class Car {

	protected Brand brand;

	public Car(Brand brand) {
		this.brand = brand;
	}

	public void info() {
		brand.info();
	}
}

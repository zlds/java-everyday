package org.example.gof.prototypepattern;

/**
 * @author: hanchaowei
 * @date 2023/4/29
 * @description:
 */

public abstract class RacketPrototype {
	protected String brand;
	protected String model;
	protected double weight;
	protected double balancePoint;

	public RacketPrototype(String brand, String model, double weight, double balancePoint) {
		this.brand = brand;
		this.model = model;
		this.weight = weight;
		this.balancePoint = balancePoint;
	}

	public abstract RacketPrototype clone();

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getWeight() {
		return weight;
	}

	public double getBalancePoint() {
		return balancePoint;
	}
}

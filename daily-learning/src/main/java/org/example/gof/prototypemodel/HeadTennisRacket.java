package org.example.gof.prototypemodel;

/**
 * @author: hanchaowei
 * @date 2023/4/29
 * @description:
 */

public class HeadTennisRacket extends RacketPrototype {
	public HeadTennisRacket(String brand, String model, double weight, double balancePoint) {
		super(brand, model, weight, balancePoint);
	}

	@Override
	public RacketPrototype clone() {
		System.out.println("HeadTennisRacket is cloned" + this.brand + this.model + this.weight + this.balancePoint);
		return new HeadTennisRacket(this.getBrand(), this.getModel(), this.getWeight(), this.getBalancePoint());
	}
}

package org.example.gof.prototypepattern;

/**
 * @author: hanchaowei
 * @date 2023/4/29
 * @description:
 */

public class WilsonTennisRacket extends RacketPrototype {
	public WilsonTennisRacket(String brand, String model, double weight, double balancePoint) {
		super(brand, model, weight, balancePoint);
	}

	@Override
	public RacketPrototype clone() {
		System.out.println("WilsonTennisRacket is cloned" + this.brand + this.model + this.weight + this.balancePoint);
		return new WilsonTennisRacket(this.getBrand(), this.getModel(), this.getWeight(), this.getBalancePoint());
	}
}

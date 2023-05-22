package org.example.gof.bridgingpattern;


/**
 * @author: hanchaowei
 * @date 2023/5/22
 * @description:
 */

public class CarTest {

	public static void main(String[] args) {
		Car car = new SportsCar(new BMW());
		car.info();

		Car audi = new SportsCar(new Audi());
		audi.info();
	}
}

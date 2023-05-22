package org.example.gof.bridgingpattern.v1;

/**
 * @author: hanchaowei
 * @date 2023/5/22
 * @description:
 */

public class ShapeTest {
	public static void main(String[] args) {
		Shape redCircle = new Circle(new Red());
		Shape blueCircle = new Circle(new Blue());

		redCircle.draw();
		blueCircle.draw();
	}
}

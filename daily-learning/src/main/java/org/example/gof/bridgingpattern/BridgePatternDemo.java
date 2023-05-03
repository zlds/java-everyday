package org.example.gof.bridgingpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class BridgePatternDemo {
	public static void main(String[] args) {
		Shape redCircle = new Circle(100,100, 10, new RedDraw());
		Shape blueCircle = new Circle(100,100, 10, new BlueDraw());

		redCircle.draw();
		blueCircle.draw();
	}
}

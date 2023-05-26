package org.example.gof.flyweightpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/26
 * @description:
 */

public class FlyweightPatternDemo {
	private static final String[] colors = {"红色","绿色","蓝色","白色","黑色"};

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			Circle circle = CircleFactory.getCircle(getRandomColor());
			circle.draw();
		}
	}
	private static String getRandomColor() {
		return colors[(int)(Math.random() * colors.length)];
	}

}

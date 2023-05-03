package org.example.gof.bridgingpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class Circle extends Shape {

	private int x, y, radius;

	protected Circle(int x, int y, int radius, DrawAPI drawAPI) {
		super(drawAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void draw() {
		drawAPI.draw(radius,x,y);
	}
}

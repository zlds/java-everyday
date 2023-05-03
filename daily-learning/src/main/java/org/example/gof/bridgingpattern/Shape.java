package org.example.gof.bridgingpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public abstract class Shape {
	protected DrawAPI drawAPI;

	public Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}

	public abstract void draw();
}

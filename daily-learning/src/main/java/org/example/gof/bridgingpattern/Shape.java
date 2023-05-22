package org.example.gof.bridgingpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description: 几何图形抽象类
 */

public abstract class Shape {
	protected DrawAPI drawAPI;

	public Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}

	public abstract void draw();
}

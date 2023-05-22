package org.example.gof.bridgingpattern.v1;

/**
 * @author: hanchaowei
 * @date 2023/5/22
 * @description: 圆形实现类
 */

public class Circle extends Shape {
	public Circle(Color color) {
		super(color);
	}

	@Override
	public void draw() {
		System.out.println("圆形");
		color.applyColor();

	}
}

package org.example.gof.bridgingpattern.v1;

/**
 * @author: hanchaowei
 * @date 2023/5/22
 * @description: 正方形实现接口
 */

public class Square extends Shape {

	public Square(Color color) {
		super(color);
	}

	@Override
	public void draw() {
		System.out.println("正方形");
		color.applyColor();
	}
}

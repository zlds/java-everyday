package org.example.gof.flyweightpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/26
 * @description: 具体的圆形类
 */

public class ConcreteCircle implements Circle {
	private String color;

	public ConcreteCircle(String color) {
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println("画了一个" + color + "的圆形");
	}
}

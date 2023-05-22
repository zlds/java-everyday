package org.example.gof.bridgingpattern.v1;

/**
 * @author: hanchaowei
 * @date 2023/5/22
 * @description: 几何图形抽象类
 */

public abstract class Shape {
	/**
	 * 桥接模式的关键，将几何图形抽象类与颜色类进行组合
	 * 当有新颜色时，只需要新增一个颜色类，不需要修改几何图形抽象类
	 */
	protected Color color;

	public Shape(Color color) {
		this.color = color;
	}

	/**
	 * 绘画
	 */
	abstract public void draw();
}

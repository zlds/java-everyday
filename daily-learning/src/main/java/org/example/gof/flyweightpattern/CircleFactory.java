package org.example.gof.flyweightpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2023/5/26
 * @description: 享元工厂，负责创建和管理享元角色
 */

public class CircleFactory {
	/**
	 * 存储已经创建的对象,当调用getCircle方法被调用时,它会检查circleMap中是否已经有一个颜色为color的圆形,如果有则直接返回
	 * ,如果没有则创建一个并放入map中.
	 */
	private static final Map<String,Circle> circleMap = new HashMap<>();

	public static Circle getCircle(String color) {
		Circle circle = circleMap.get(color);
		if (circle == null) {
			circle = new ConcreteCircle(color);
			circleMap.put(color,circle);
			System.out.println("创建了一个" + color + "的圆形");
		}
		return circle;
	}
}

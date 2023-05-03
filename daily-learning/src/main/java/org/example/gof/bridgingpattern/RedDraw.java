package org.example.gof.bridgingpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class RedDraw implements DrawAPI {

	@Override
	public void draw(int radius, int x, int y) {
		System.out.println("用红色画笔画图，radius:" + radius + ",x:" + x + ",y:" + y);
	}

}

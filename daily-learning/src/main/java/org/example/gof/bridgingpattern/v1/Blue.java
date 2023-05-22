package org.example.gof.bridgingpattern.v1;

/**
 * @author: hanchaowei
 * @date 2023/5/22
 * @description: 绿色
 */

public class Blue implements Color {
	@Override
	public void applyColor() {
		System.out.println("蓝色");
	}
}

package org.example.gof.bridgingpattern.v1;

/**
 * @author: hanchaowei
 * @date 2023/5/22
 * @description: 红色
 */

public class Red implements Color {

	@Override
	public void applyColor() {
		System.out.println("红色");
	}
}

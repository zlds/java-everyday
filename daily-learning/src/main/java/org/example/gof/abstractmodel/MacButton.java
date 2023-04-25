package org.example.gof.abstractmodel;

/**
 * @author: hanchaowei
 * @date 2023/4/25
 * @description: Mac 按钮
 */

public class MacButton implements Button {
	@Override
	public void render() {
		System.out.println("MacButton");
	}
}

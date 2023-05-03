package org.example.gof.abstractpattern;

/**
 * @author: hanchaowei
 * @date 2023/4/25
 * @description: Windows 按钮
 */

public class WindowsButton implements Button {
	@Override
	public void render() {
		System.out.println("WindowsButton");
	}
}

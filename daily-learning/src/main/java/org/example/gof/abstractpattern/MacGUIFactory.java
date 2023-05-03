package org.example.gof.abstractpattern;

/**
 * @author: hanchaowei
 * @date 2023/4/25
 * @description: Mac GUI 工厂
 */

public class MacGUIFactory implements GUIFactory {
	@Override
	public Button createButton() {
		return new MacButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new MacCheckbox();
	}
}

package org.example.gof.abstractmodel;

/**
 * @author: hanchaowei
 * @date 2023/4/25
 * @description: Windows GUI 工厂
 */

public class WindowsGUIFactory implements GUIFactory {
	@Override
	public Button createButton() {
		return new WindowsButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new WindowsCheckbox();
	}

}

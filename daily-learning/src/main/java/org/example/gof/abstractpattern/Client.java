package org.example.gof.abstractpattern;

/**
 * @author: hanchaowei
 * @date 2023/4/25
 * @description:
 */

public class Client {
	public static void main(String[] args) {
		GUIFactory guiFactory;
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("mac")) {
			guiFactory = new MacGUIFactory();
		} else {
			guiFactory = new WindowsGUIFactory();
		}

		Button button = guiFactory.createButton();
		button.render();

		Checkbox checkbox = guiFactory.createCheckbox();
		checkbox.render();
	}
}

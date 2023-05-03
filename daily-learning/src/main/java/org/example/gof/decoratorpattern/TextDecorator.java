package org.example.gof.decoratorpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public abstract class TextDecorator implements Text {
	private Text decoratedText;

	public TextDecorator(Text decoratedText) {
		this.decoratedText = decoratedText;
	}

	@Override
	public String getContent() {
		return decoratedText.getContent();
	}
}

package org.example.gof.decoratorpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class PrefixDecorator extends TextDecorator {
	public PrefixDecorator(Text decoratedText) {
		super(decoratedText);
	}

	@Override
	public String getContent() {
		return "Prefix " + super.getContent();
	}
}

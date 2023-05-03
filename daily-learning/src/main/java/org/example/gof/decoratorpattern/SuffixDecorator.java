package org.example.gof.decoratorpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class SuffixDecorator extends TextDecorator {

	public SuffixDecorator(Text decoratedText) {
		super(decoratedText);
	}

	@Override
	public String getContent() {
		return super.getContent() + " Suffix";
	}
}

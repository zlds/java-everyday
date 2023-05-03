package org.example.gof.decoratorpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class PlainText implements Text {
	private String text;

	public PlainText(String text) {
		this.text = text;
	}

	@Override
	public String getContent() {
		return this.text;
	}
}

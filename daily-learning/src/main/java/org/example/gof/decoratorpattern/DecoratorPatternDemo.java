package org.example.gof.decoratorpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class DecoratorPatternDemo {
	public static void main(String[] args) {
		Text plainText = new PlainText("Hello, world!");

		Text prefixDecorated = new PrefixDecorator(plainText);
		System.out.println(prefixDecorated.getContent());

		Text suffixDecorated = new SuffixDecorator(plainText);
		System.out.println(suffixDecorated.getContent());

		Text bothDecorated = new PrefixDecorator(new SuffixDecorator(plainText));
		System.out.println(bothDecorated.getContent());




	}
}

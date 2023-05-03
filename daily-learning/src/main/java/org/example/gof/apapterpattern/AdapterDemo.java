package org.example.gof.apapterpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/1
 * @description:
 */

public class AdapterDemo {
	public static void main(String[] args) {
		// 原本的欧洲插头
		EuropeanPlug europeanPlug = new EuropeanPlug();
		// 将插头转换成美国插头
		AmericanPlug americanPlug = new PlugAdapter(europeanPlug);
		americanPlug.threePinPlug();
	}
}

package org.example.gof.templatepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class Tea extends CaffeineBeverage {

	@Override
	public void brew() {
		System.out.println("冲泡茶");
	}

	@Override
	public void addCondiments() {
		System.out.println("加柠檬");
	}
}

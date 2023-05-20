package org.example.gof.templatepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description: 咖啡类
 */

public class Coffee extends CaffeineBeverage {

	@Override
	public void brew() {
		System.out.println("冲泡咖啡");
	}

	@Override
	public void addCondiments() {
		System.out.println("加糖和牛奶");
	}
}

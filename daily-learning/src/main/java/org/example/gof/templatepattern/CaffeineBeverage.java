package org.example.gof.templatepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description: 制作咖啡或茶
 */

public abstract class CaffeineBeverage {

	/**
	 * 模板方法
	 */
	final void prepareRecipe() {
		// 烧水
		boilWater();
		// 冲泡
		brew();
		// 倒进杯子
		pourInCup();
		// 加调料
		addCondiments();
	}

	void boilWater() {
		System.out.println("烧水");
	}

	void pourInCup() {
		System.out.println("倒进杯子");
	}


	abstract void brew();

	abstract void addCondiments();






}

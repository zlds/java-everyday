package org.example.gof.buildepattern;

/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description:
 */

public class NonVegetarianMealBuilder extends MealBuilder {
	@Override
	public void buildDrink() {
		meal.setDrink("可乐");
	}

	@Override
	public void buildMainCourse() {
		meal.setMainCourse("牛肉汉堡");
	}

	@Override
	public void buildDessert() {
		meal.setDessert("冰淇淋");
	}
}

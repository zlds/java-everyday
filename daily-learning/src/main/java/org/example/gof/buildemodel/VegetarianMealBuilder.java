package org.example.gof.buildemodel;

/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description:
 */

public class VegetarianMealBuilder extends MealBuilder {

	@Override
	public void buildDrink() {
		meal.setDrink("可乐");
	}

	@Override
	public void buildMainCourse() {
		meal.setMainCourse("素食汉堡");
	}

	@Override
	public void buildDessert() {
		meal.setDessert("水果沙拉");
	}

}

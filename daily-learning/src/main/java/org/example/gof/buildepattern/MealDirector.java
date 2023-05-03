package org.example.gof.buildepattern;

/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description:
 */

public class MealDirector {

	private MealBuilder builder;

	public MealDirector(MealBuilder builder) {
		this.builder = builder;
	}

	public void constructMeal() {
		builder.buildDrink();
		builder.buildMainCourse();
		builder.buildDessert();
	}
}

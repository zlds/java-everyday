package org.example.gof.buildepattern;

/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description:
 */

public abstract class MealBuilder {
	protected Meal meal = new Meal();

	public MealBuilder() {
		this.meal = meal;
	}

	public abstract void buildDrink();
	public abstract void buildMainCourse();
	public abstract void buildDessert();

}

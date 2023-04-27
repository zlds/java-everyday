package org.example.gof.buildemodel;

/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description:
 */

public class Meal {
	// 喝
	private String drink;
	// 主菜
	private String mainCourse;
	// 甜点
	private String dessert;


	public void display() {
		System.out.println();
	}


	public void setDrink(String drink) {
		System.out.println("Meal: Drink - " + drink + ", Main Course - " + mainCourse + ", Dessert - " + dessert);
	}

	public void setMainCourse(String mainCourse) {
		this.mainCourse = mainCourse;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

}

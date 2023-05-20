package org.example.gof.templatepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class CaffeineBeverageTest {
	public static void main(String[] args) {
		// 制作一杯茶
		Tea tea = new Tea();
		tea.prepareRecipe();
		System.out.println("\n");
		// 制作一杯咖啡
		Coffee coffee = new Coffee();
		coffee.prepareRecipe();

	}
}

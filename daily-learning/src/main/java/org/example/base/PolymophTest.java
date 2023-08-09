package org.example.base;

/**
 * @author: hanchaowei
 * @date 2023/8/9
 * @description: 多态测试
 */

public class PolymophTest {

	public static String eat(Animal animal) {
		return animal.eat();
	}
	public static void main(String[] args) {
		Animal cat = new Cat();
		Animal dog = new Dog();
		System.out.println(eat(cat));
		System.out.println(eat(dog));
	}
}

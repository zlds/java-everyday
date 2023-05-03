package org.example.gof.prototypepattern;

/**
 * @author: hanchaowei
 * @date 2023/4/29
 * @description:
 */

public class SheepTest {

	public static void main(String[] args) {
		Sheep originalSheep = new Sheep("Dolly");
		try {
			Sheep cloned = (Sheep) originalSheep.clone();
			System.out.println("Original Sheep Name: " + originalSheep.getName());
			System.out.println("Cloned Sheep Name: " + cloned.getName());
			originalSheep.setName("xiaoen");
			System.out.println("Original Sheep Name: " + originalSheep.getName());
			System.out.println("Cloned Sheep Name: " + cloned.getName());
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
}

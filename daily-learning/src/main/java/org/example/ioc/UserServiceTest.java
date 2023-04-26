package org.example.ioc;

/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description:
 * 需要程序员手动控制对象的创建，对象之间的依赖关系也需要程序员手动注入。
 */

public class UserServiceTest {

	public static boolean doTest() {
		return true;
	}

	public static void main(String[] args) {
		if (doTest()) {
			System.out.println("Test succeed.");
		} else {
			System.out.println("Test failed.");
		}
	}
}

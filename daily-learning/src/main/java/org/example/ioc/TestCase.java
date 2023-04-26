package org.example.ioc;

/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description:
 */

public abstract class TestCase {
	public abstract boolean doTest();

	public void run() {
		if (doTest()) {
			System.out.println("Test succeed.");
		} else {
			System.out.println("Test failed.");
		}
	}

}

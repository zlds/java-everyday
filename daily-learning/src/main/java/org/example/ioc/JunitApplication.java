package org.example.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description:
 */

public class JunitApplication {
	private static final List<TestCase> testCases = new ArrayList<>();


	static {
		register(new MathTest());
	}

	public static void register(TestCase testCase) {
		testCases.add(testCase);
	}


	public static void main(String[] args) {
		/*
		在没有JunitApplication的情况下，我们需要手动创建TestCase对象并调用run()方法来执行测试用例,如果有N个测试用例，
		我们就需要创建N个对象并逐步执行run()方法，非常麻烦。

		如果我们有JunitApplication的情况下，只需要关注测试用例的编写，不需要关心如何执行测试用例。而如果有新增，只需要注册到JunitApplication中即可。
		这种方式就是IOC的思想，将创建对象的控制权交给JunitApplication，而不是由我们自己去创建对象。
		 */

//		MathTest mathTest = new MathTest();
//		mathTest.run();


		// 通过反射获取所有的测试类
		for (TestCase testCase : testCases) {
			testCase.run();
		}
	}
}

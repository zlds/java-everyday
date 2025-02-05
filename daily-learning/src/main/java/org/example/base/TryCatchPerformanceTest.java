package org.example.base;

/**
 * @author: hanchaowei
 * @date 2025/2/5
 * @description: try-catch性能测试
 */

public class TryCatchPerformanceTest {

	public static void main(String[] args) {
		int count = 1000000;
		// 正常测试
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			try {
				int result = divide(10,2);
			} catch (Exception e) {

			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("正常try-catch耗时：" + (endTime - startTime) + "ms");

		/**
		 * 异常测试。异常发生时需要创建异常对象、生成调用栈信息、异常匹配(需要从抛出异常的位置向上匹配)，最后是执行对应的异常代码，这些都是耗时的操作。
		 */
		startTime = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			try {
				int result = divide(10,0);
			} catch (Exception e) {

			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("异常try-catch耗时：" + (endTime - startTime) + "ms");
	}

	public static int divide(int a,int b) throws Exception {
		if (b == 0) {
			throw new Exception("除数不能为0");
		}
		return a / b;
	}
}

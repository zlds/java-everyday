package org.example.ioc;
/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description:
 */

public class MathTest extends TestCase {
	@Override
	public boolean doTest() {
		Math math = new Math();
		return math.add(2, 3) == 5;
	}
}

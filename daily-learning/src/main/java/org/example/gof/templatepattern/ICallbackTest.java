package org.example.gof.templatepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class ICallbackTest {
	public static void main(String[] args) {
		ICallback myCallback = new MyCallback();
		Task task = new Task(myCallback);
		task.execute();
	}
}

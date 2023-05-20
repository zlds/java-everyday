package org.example.gof.templatepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class MyCallback implements ICallback {
	@Override
	public void preExecute() {
		System.out.println("执行任务前");
	}

	@Override
	public void postExecute() {
		System.out.println("执行任务后");
	}
}

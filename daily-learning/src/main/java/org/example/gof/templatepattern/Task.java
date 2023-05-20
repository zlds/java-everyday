package org.example.gof.templatepattern;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class Task {

	private ICallback iCallback;

	public Task(ICallback iCallback) {
		this.iCallback = iCallback;
	}

	public void execute() {
		iCallback.preExecute();
		System.out.println("执行任务");
		iCallback.postExecute();
	}
}

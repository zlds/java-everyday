package org.example.gof.chainpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description:
 */

public abstract class Handler {
	protected Handler successor;

	/**
	 * 设定下一个处理请求的人
	 * @param successor
	 */
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	/**
	 * 处理请求的方法，由子类实现
	 * @param request
	 */
	public abstract void handleRequest(int request);
}

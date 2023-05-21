package org.example.gof.chainpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description:
 */

public class HandlerA extends Handler {
	@Override
	public void handleRequest(int request) {
		if (request < 10) {
			System.out.println("A处理了请求：" + request);
		} else if (successor != null) {
			// 交给下一个处理器处理
			successor.handleRequest(request);
		}
	}
}

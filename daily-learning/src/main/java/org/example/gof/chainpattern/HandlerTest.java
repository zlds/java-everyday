package org.example.gof.chainpattern;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description:
 */

public class HandlerTest {
	public static void main(String[] args) {
		// 创建处理器
		Handler handlerA = new HandlerA();
		Handler handlerB = new HandlerB();
		// 设置handlerA的下一个处理器是handlerB
		handlerA.setSuccessor(handlerB);
		// 发起请求
		for (int i = 0; i < 30; i++) {
			handlerA.handleRequest(i);
		}
	}
}

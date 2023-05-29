package org.example.gof.solid.dip;

/**
 * @author: hanchaowei
 * @date 2023/5/28
 * @description:
 */

public class MessageTest {

	// MessageService(高层)依赖于MessagePrivider接口(抽象),而不是具体的消息发送方(实现)
	public static void main(String[] args) {
		MessageService messageService = new MessageService(new EmailProvider());
		messageService.send("测试");
	}
}

package org.example.di;

/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description: 消息推送
 */

public class Notification {
	// 依赖注入，MessageSender实现推送商品促销，验证码等消息
	private MessageSender messageSender;

	// 非依赖注入
//	public Notification() {
//		this.messageSender = new MessageSender();
//	}

	// 依赖注入,通过构造函数将MessageSender注入进来
	public Notification(MessageSender messageSender) {
		this.messageSender = messageSender;
	}

	public void sendMessage(String cellphone, String message) {
		this.messageSender.send(cellphone, message);
	}
}

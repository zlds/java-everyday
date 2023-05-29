package org.example.gof.solid.dip;

/**
 * @author: hanchaowei
 * @date 2023/5/28
 * @description:
 */

public class SmsProvider implements MessageProvider {

	@Override
	public void sendMessage(String message) {
		System.out.println("发送短信消息：" + message);
	}
}

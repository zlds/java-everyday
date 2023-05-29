package org.example.gof.solid.dip;

/**
 * @author: hanchaowei
 * @date 2023/5/28
 * @description:
 */

public class PushNotificationProvider implements MessageProvider {

	@Override
	public void sendMessage(String message) {
		System.out.println("发送推送消息：" + message);
	}
}

package org.example.gof.solid.dip;

/**
 * @author: hanchaowei
 * @date 2023/5/28
 * @description:
 */

public class EmailProvider implements MessageProvider {

	@Override
	public void sendMessage(String message) {
		System.out.println("发送邮件消息：" + message);
	}
}

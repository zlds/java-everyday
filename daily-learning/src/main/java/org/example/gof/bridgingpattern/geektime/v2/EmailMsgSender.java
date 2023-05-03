package org.example.gof.bridgingpattern.geektime.v2;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class EmailMsgSender implements MsgSender {
	private List<String>  emailAddresses;

	public EmailMsgSender(List<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	@Override
	public void send(String message) {
		// 业务逻辑
		System.out.println("邮件发送");
	}
}

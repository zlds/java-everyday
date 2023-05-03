package org.example.gof.bridgingpattern.geektime.v2;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class TelephoneMsgSender implements MsgSender {
	private List<String> telephones;

	public TelephoneMsgSender(List<String> telephones) {
		this.telephones = telephones;
	}

	@Override
	public void send(String message) {
		// 业务逻辑
		System.out.println("自动语音电话");
	}
}

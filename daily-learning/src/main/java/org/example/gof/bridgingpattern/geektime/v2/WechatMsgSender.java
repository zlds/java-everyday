package org.example.gof.bridgingpattern.geektime.v2;

import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class WechatMsgSender implements MsgSender {
	private List<String> wechatIds;

	public WechatMsgSender(List<String> wechatIds) {
		this.wechatIds = wechatIds;
	}

	@Override
	public void send(String message) {
		// 业务逻辑
		System.out.println("微信发送");
	}
}

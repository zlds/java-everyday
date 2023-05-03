package org.example.gof.bridgingpattern.geektime.v2;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class NormalNotification extends Notification {
	public NormalNotification(MsgSender msgSender) {
		super(msgSender);
	}

	@Override
	public void notify(String message) {
		System.out.println("普通级别通知");
	}
}

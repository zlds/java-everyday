package org.example.gof.bridgingpattern.geektime.v2;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class UrgencyNotification extends Notification {

	public UrgencyNotification(MsgSender msgSender) {
		super(msgSender);
	}

	@Override
	public void notify(String message) {
		System.out.println("紧急级别通知");
	}
}

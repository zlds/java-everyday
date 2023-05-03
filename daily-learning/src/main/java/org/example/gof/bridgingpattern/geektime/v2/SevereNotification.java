package org.example.gof.bridgingpattern.geektime.v2;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class SevereNotification extends Notification {

	public SevereNotification(MsgSender msgSender) {
		super(msgSender);
	}

	@Override
	public void notify(String message) {
		System.out.println("严重级别通知");
	}
}

package org.example.gof.bridgingpattern.geektime.v2;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class TrivialNotification extends Notification {
	public TrivialNotification(MsgSender msgSender) {
		super(msgSender);
	}

	@Override
	public void notify(String message) {
		System.out.println("无关紧要级别通知");
	}
}

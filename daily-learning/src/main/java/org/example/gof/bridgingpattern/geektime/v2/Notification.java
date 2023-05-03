package org.example.gof.bridgingpattern.geektime.v2;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public abstract class Notification {
	protected MsgSender msgSender;

	public Notification(MsgSender msgSender) {
		this.msgSender = msgSender;
	}

	public abstract void notify(String message);
}

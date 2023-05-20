package org.example.gof.observerpattern.geektime.v2;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class NotificationService {
	public void sendInboxMessage(long userId, String s) {
		System.out.println(s);
	}
}

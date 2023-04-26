package org.example.di;

/**
 * @author: hanchaowei
 * @date 2023/4/26
 * @description:
 */

public class NotificationTest {
	public static void main(String[] args) {
		MessageSender messageSender = new MessageSender();
		Notification notification = new Notification(messageSender);
		notification.sendMessage("123456789", "hello world");
	}
}

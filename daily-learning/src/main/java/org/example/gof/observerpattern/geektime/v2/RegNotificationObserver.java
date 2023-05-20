package org.example.gof.observerpattern.geektime.v2;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class RegNotificationObserver implements RegObserver {
	// 依赖注入
	private NotificationService notificationService;

	@Override
	public void handleRegSuccess(long userId) {
		notificationService.sendInboxMessage(userId, "Welcome...");
	}
}

package org.example.gof.observerpattern.geektime.v2;

/**
 * @author: hanchaowei
 * @date 2023/5/20
 * @description:
 */

public class RegPromotionObserver implements RegObserver {
	private PromotionService promotionService; // 依赖注入

	@Override
	public void handleRegSuccess(long userId) {
		promotionService.issueNewUserExperienceCash(userId);
	}
}

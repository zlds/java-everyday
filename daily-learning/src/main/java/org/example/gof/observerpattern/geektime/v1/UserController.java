package org.example.gof.observerpattern.geektime.v1;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class UserController {
	/**
	 * 需求是用户注册成功后发送体验金给用户
	 * 问题：如果后续还有其他需求，比如用户注册成功后，发送优惠券给用户，那么就需要修改UserController的代码，违法了单一原则
	 */

	private UserService userService;
	private PromotionService promotionService;

	public void region(String telephone, String password) {
		long userId = userService.register("10001", "123456");
		// 用户注册成功后，将投资体验金发给用户。
		promotionService.issueNewUserExperienceCash(userId);
	}
}

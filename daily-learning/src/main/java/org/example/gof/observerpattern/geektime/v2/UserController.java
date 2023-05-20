package org.example.gof.observerpattern.geektime.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description:
 */

public class UserController {

	/**
	 * v2模式中通过观察者模式，将注册成功后的逻辑抽离出来，放到观察者中，降低了耦合性。后续只需要将新增放到观察者中即可。
	 */




	private UserService userService;

	private List<RegObserver> observerList = new ArrayList<>();

	public void setRegObserver(List<RegObserver> observerList) {
		observerList.addAll(observerList);
	}


	public void region(String telephone, String password) {
		long userId = userService.register("10001", "123456");
		// 用户注册成功后，将投资体验金发给用户,同时发送站类信。
		for (RegObserver regObserver : observerList) {
			regObserver.handleRegSuccess(userId);
		}

	}
}

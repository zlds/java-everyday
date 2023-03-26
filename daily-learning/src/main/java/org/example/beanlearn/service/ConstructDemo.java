package org.example.beanlearn.service;

import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/26
 * @description: 构造方法学习
 */

@Component
public class ConstructDemo {

	private UserInfoService userInfoService;
	/**
	 * 1、在Spring中假如我现在有两个构造方法，一个无参，一个有参，会用哪一个?
	 * 答：会使用无参
	 * 2、如果有两个有参构造方法会是什么情况
	 * 答：Failed to instantiate [org.example.beanlearn.service.ConstructDemo]: No default constructor found
	 * 因为他不知道使用哪个一个构造方法。
	 * 3、假如只有一个有参构造方法
	 * 答：可以使用
	 */

//	public ConstructDemo() {
//		System.out.println(0);
//	}

	public ConstructDemo(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
		System.out.println(1);
	}


	//	public ConstructDemo(Integer i,String s) {
//		System.out.println(i);
//	}
}

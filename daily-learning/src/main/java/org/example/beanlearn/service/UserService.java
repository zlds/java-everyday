package org.example.beanlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/23
 * @description:
 */
@Component
public class UserService {

	@Autowired
	UserInfoService userInfoService;

	/**
	 * 不通过Autowired注解，通过构造方法注入
	 */
//	UserInfoService userInfoService;
//
//	public UserService(UserInfoService userInfoService) {
//		this.userInfoService = userInfoService;
//	}

	public void test() {
		System.out.println(userInfoService);
	}
}

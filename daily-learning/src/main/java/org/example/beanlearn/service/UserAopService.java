package org.example.beanlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/26
 * @description:
 */

@Component
public class UserAopService {

	@Autowired
	private UserInfoService userInfoService;

	public void test() {
		System.out.println("UserAopService.test()");
	}
}

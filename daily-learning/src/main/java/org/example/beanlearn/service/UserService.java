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

	public void test() {
		System.out.println(userInfoService);
	}
}

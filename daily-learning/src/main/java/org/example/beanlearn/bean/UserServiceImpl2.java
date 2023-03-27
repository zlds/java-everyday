package org.example.beanlearn.bean;

import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2023/3/27
 * @description:
 */

@Service("userService2")
public class UserServiceImpl2 implements UserService {

	@Override
	public void save(User user) {
		System.out.println("我是UserServiceImpl2的save方法");
	}
}

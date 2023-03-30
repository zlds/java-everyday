package org.example.beanlearn.bean;

import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/30
 * @description:
 */

@Component
public class UserServiceResourceImpl1 implements UserServiceResource {

	@Override
	public void getMessage() {
		System.out.println("我是UserServiceResourceImpl1的getMessage方法");
	}
}

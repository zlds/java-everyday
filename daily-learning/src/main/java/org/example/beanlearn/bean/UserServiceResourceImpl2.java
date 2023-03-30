package org.example.beanlearn.bean;

import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/30
 * @description:
 */

@Component
public class UserServiceResourceImpl2 implements UserServiceResource {

	@Override
	public void getMessage() {
		System.out.println("我是UserServiceResourceImpl2的getMessage方法");
	}
}

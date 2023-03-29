package org.example.beanlearn.bean;

import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/29
 * @description:
 */

@Component
public class UserServicePrimaryImpl1 implements UserServicePrimary {
	@Override
	public void getMessage() {
		System.out.println("我是UserServicePrimaryImpl1的getMessage方法");
	}
}

package org.example.beanlearn.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/29
 * @description:
 */

@Component
@Primary
public class UserServicePrimaryImpl2 implements UserServicePrimary {
	@Override
	public void getMessage() {
		System.out.println("我是UserServicePrimaryImpl2的getMessage方法");
	}
}

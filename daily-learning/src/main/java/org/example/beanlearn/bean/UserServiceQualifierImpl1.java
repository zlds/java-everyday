package org.example.beanlearn.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/30
 * @description:
 */

@Component
@Qualifier("serviceQualifier1")
public class UserServiceQualifierImpl1 implements UserServiceQualifier {

	@Override
	public void getMessage() {
		System.out.println("我是UserServiceQualifierImpl1的getMessage方法");
	}
}

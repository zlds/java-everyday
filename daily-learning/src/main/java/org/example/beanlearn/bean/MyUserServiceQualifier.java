package org.example.beanlearn.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/30
 * @description:
 */

@Component
public class MyUserServiceQualifier {

	private final UserServiceQualifier userServiceQualifier1;
	private final UserServiceQualifier userServiceQualifier2;

	public MyUserServiceQualifier(@Qualifier("serviceQualifier1") UserServiceQualifier userServiceQualifier1,
			@Qualifier("serviceQualifier2") UserServiceQualifier userServiceQualifier2) {
		this.userServiceQualifier1 = userServiceQualifier1;
		this.userServiceQualifier2 = userServiceQualifier2;
	}

	public void getMessage1() {
		userServiceQualifier1.getMessage();
	}

	public void getMessage2() {
		userServiceQualifier2.getMessage();
	}
}

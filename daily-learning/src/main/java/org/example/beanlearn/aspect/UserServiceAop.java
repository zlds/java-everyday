package org.example.beanlearn.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/26
 * @description:
 */

@Component
@Aspect
public class UserServiceAop {

	@Before("execution(public void org.example.beanlearn.service.UserAopService.test())")
	public void before() {
		System.out.println("UserServiceAop.before()");
	}
}

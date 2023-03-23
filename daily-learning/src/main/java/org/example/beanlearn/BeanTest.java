package org.example.beanlearn;

import org.example.beanlearn.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: hanchaowei
 * @date 2023/3/23
 * @description: Bean测试
 */

public class BeanTest {
	public static void main(String[] args) {
		// 创建spring容器,获取Spring应用的上下文
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// 通过beanName获取对象。
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.test();
	}
}

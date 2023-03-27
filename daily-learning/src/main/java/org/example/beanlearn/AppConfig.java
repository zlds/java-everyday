package org.example.beanlearn;

import org.example.beanlearn.service.UserInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/23
 * @description: 定义扫描路径
 */

@ComponentScan("org.example.beanlearn.service")
@EnableAspectJAutoProxy
public class AppConfig {

	// 定义两个相同类型的Bean，测试Bean查找
	@Bean
	public UserInfoService userInfoService1() {
		return new UserInfoService();
	}

	@Bean
	public UserInfoService userInfoService2() {
		return new UserInfoService();
	}
}

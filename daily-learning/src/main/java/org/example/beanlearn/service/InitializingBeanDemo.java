package org.example.beanlearn.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;

/**
 * @author: hanchaowei
 * @date 2023/3/26
 * @description:
 */
@Component
public class InitializingBeanDemo implements InitializingBean {

	/**
	 * 执行顺序
	 * 1.构造方法
	 * 2.@PostConstruct
	 * 3.InitializingBean的afterPropertiesSet方法
	 */

	public InitializingBeanDemo() {
		System.out.println("我是构造方法，我第一个执行....");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("我是afterPropertiesSet方法，我会在构造方法和PostConstruct注解执行之后执行....");
	}


	@PostConstruct
	public void init() {
		System.out.println("我是PostConstruct注解的init方法，我会在构造方法执行之后执行....");
	}

	public void show() {
		System.out.println("我是show方法");
	}
}

package org.example.beanlearn.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: hanchaowei
 * @date 2023/3/24
 * @description:
 */

@Component
public class PostConstructDemo {
	private String message;

	public PostConstructDemo() {
		System.out.println("PostConstructDemo构造方法");
	}

	/**
	 * 执行完构造方法后执行该方法
	 */
	@PostConstruct
	public void init() {
		System.out.println("PostConstructDemo初始化方法");
		this.message = "Hello,Word!";
	}

	public String getMessage() {
		return message;
	}
}




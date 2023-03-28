package org.example.beanlearn.bean;

import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/28
 * @description:
 */

@Component("myBeanName") // 自定beanName
public class FindByBeanName {
	public void getMessage() {
		System.out.println("findByBeanName");
	}
}

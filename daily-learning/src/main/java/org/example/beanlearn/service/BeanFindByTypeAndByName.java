package org.example.beanlearn.service;

import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/3/26
 * @description:
 */

@Component
public class BeanFindByTypeAndByName {
	private UserInfoService userInfoService;

	/**
	 * 构造函数如何查找UserInfoService并传递引用?
	 * 最简单的就是根据类型UserInfoService，在单例Bean，map<beanName,bean对象>中查找
	 * @param userInfoService
	 */
	public BeanFindByTypeAndByName(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

}

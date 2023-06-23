package org.example.service;

import org.example.controller.vo.UserReq;

/**
 * @author: hanchaowei
 * @date 2023/6/22
 * @description: 用户接口
 */

public interface IUserService {

	/**
	 * 添加用户
	 * @param req
	 */
	void add(UserReq req);

	/**
	 * 判断手机号是否被注册
	 * @param mobile
	 * @return
	 */
	boolean isRegistered(String mobile);

}

package org.example.service;

import org.example.controller.vo.UserReq;
import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2023/6/22
 * @description:
 */

@Service
public class IUserServiceImpl implements IUserService {

	@Override
	public void add(UserReq req) {
	}

	@Override
	public boolean isRegistered(String mobile) {
		return false;
	}
}

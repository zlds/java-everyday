package org.example.service;

import org.example.controller.vo.UserReq;
import org.example.dal.dao.SysUserMapper;
import org.example.dal.model.SysUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2023/6/22
 * @description:
 */

@Service
public class IUserServiceImpl implements IUserService {

	private  ModelMapper modelMapper;

	private SysUserMapper sysUserMapper;

	@Override
	public void add(UserReq req) {
		SysUser user = modelMapper.map(req, SysUser.class);
		sysUserMapper.insert(user);
	}

	@Override
	public boolean isRegistered(String mobile) {
		return false;
	}


	/**
	 * vo转换为model
	 * @param userReq
	 * @return
	 */
	private SysUser convertToModel(UserReq userReq) {
		return modelMapper.map(userReq, SysUser.class);
	}
}

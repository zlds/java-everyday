package org.example.service;


import org.example.controller.vo.UserReq;
import org.example.dal.model.SysUser;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class IUserServiceTest {

	@Test
	public void get() {
		UserReq req = new UserReq();
		req.setUserName("zhangsan");
		req.setNickName("张三");
		req.setPassword("1111111");
		ModelMapper modelMapper = new ModelMapper();
		SysUser sysUser = modelMapper.map(req, SysUser.class);
		System.out.println(sysUser.getUserName());

	}


}
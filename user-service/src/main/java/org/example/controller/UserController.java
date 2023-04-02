package org.example.controller;

import org.example.dto.UserAddDTO;
import org.example.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hanchaowei
 * @date 2023/3/12
 * @description:
 */

@RestController
@RequestMapping("/user")
public class UserController {
	/**
	 * 通过id获取用户
	 * @param id
	 * @return
	 */
	@GetMapping("/get")
	public UserDTO getUser(@RequestParam("id") Integer id) {
		return  new UserDTO().setId(id).setNickname("zhangsan")
				.setMobile("12345678911").setGender(1);
	}

	/**
	 * 添加用户
	 * @param addDTO
	 * @return
	 */
	@GetMapping("/add")
	public Integer add(UserAddDTO addDTO) {
		return (int) (System.currentTimeMillis() / 1000);
	}













}

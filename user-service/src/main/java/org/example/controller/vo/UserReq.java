package org.example.controller.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author: hanchaowei
 * @date 2023/6/22
 * @description:
 */

public class UserReq {

	/**
	 * 登录用户名
	 */
	@NotBlank(message = "用户名不能为空")
	@Length(max = 50,message = "用户名长度不能超过50个字符")
	private String userName;

	/**
	 * 密码
	 */
	@NotBlank(message = "密码不能为空")
	@Length(min = 4, max = 16, message = "密码长度为 6-18 位")
	private String password;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 手机号
	 */
	@NotBlank(message = "手机号不能为空")
	private String phone;

	/**
	 * 邮箱
	 */
	private String email;


}

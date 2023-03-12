package org.example.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: hanchaowei
 * @date 2023/3/12
 * @description:
 */

@Data
public class UserAddDTO implements Serializable {
	private static final long serialVersionUID = -8756902976651381049L;

	/**
	 * 手机
	 */
	private String mobile;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 性别
	 */
	private Integer gender;

}

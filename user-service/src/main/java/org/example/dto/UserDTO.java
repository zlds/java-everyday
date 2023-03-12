package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: hanchaowei
 * @date 2023/3/12
 * @description:
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = -4660966970668568378L;

	/**
	 * 用户编号
	 */
	private Integer id;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 性别
	 */
	private Integer gender;

}

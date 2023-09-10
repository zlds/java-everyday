package org.example.dal.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;


import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2023/6/18
 * @description:
 */

@TableName("sys_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class SysUser {

	/**
	 * id
	 */
	private int id;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 头像
	 */
	private String remark;

	/**
	 * 部门id
	 */
	private int deptId;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 性别
	 */
	private Integer sex;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 登录ip
	 */
	private String loginIp;

	/**
	 * 登录时间
	 */
	private Date loginTime;

	/**
	 * 创建人
	 */
	private String creator;

	/**
	 * 更新人
	 */
	private String updater;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 是否删除
	 */
	private Integer deleted;

}

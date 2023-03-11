package org.example.list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: hanchaowei
 * @date 2023/3/11
 * @description:
 */

public class ListSkillLearn {
	public static void main(String[] args) {
		Set<Long> needInsertRoles = new HashSet<>();
		needInsertRoles.add(1L);
		// 生成列表插入数据库
		List<User> u1 = needInsertRoles.stream().map(roleId -> {
			User user = new User();
			user.setId(roleId);
			user.setName("u1");
			return user;
		}).collect(Collectors.toList());

		// dto批量插入数据库
	}
}

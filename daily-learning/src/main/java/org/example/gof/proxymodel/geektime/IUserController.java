package org.example.gof.proxymodel.geektime;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description:
 */

public interface IUserController {
	UserVo login(String telephone, String password);

	UserVo register(String telephone, String password);
}

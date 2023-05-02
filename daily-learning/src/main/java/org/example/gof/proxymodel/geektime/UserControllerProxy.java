package org.example.gof.proxymodel.geektime;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: hanchaowei
 * @date 2023/5/2
 * @description: 通过代理类实现对UserController扩展和增强
 */

public class UserControllerProxy implements IUserController {
	private MetricsCollector metricsCollector;
	private UserController userController;

	public UserControllerProxy(UserController userController) {
		this.userController = userController;
		this.metricsCollector = new MetricsCollector();
	}

	@Override
	public UserVo login(String telephone, String password) {
		long startTimestamp = System.currentTimeMillis();
		// 委托
		UserVo userVo = userController.login(telephone, password);
		long endTimeStamp = System.currentTimeMillis();
		long responseTime = endTimeStamp - startTimestamp;
//		RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
//		metricsCollector.recordRequest(requestInfo);
		metricsCollector.recordRequest();
		return userVo;
	}

	@Override
	public UserVo register(String telephone, String password) {
		long startTimestamp = System.currentTimeMillis();
		UserVo userVo = userController.register(telephone, password);
		long endTimeStamp = System.currentTimeMillis();
		long responseTime = endTimeStamp - startTimestamp;
//		RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
//		metricsCollector.recordRequest(requestInfo);
		metricsCollector.recordRequest();
		return userVo;
	}
}

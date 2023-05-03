package org.example.gof.proxypattern.geektime;

/**
 * @author: hanchaowei
 * @date 2023/5/3
 * @description: 假设UserController是外部类，在无法修改原始类的情况下，
 * 可以让代理类继承原始类，然后扩展附加功能。
 */

public class UserControllerProxyExtend extends UserController {
	private MetricsCollector metricsCollector;

	public UserControllerProxyExtend() {
		this.metricsCollector = new MetricsCollector();
	}

	public UserVo login(String telephone, String password) {
		long startTimestamp = System.currentTimeMillis();
		UserVo userVo = super.login(telephone, password);
		long endTimeStamp = System.currentTimeMillis();
		long responseTime = endTimeStamp - startTimestamp;
		//		RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
		//		metricsCollector.recordRequest(requestInfo);
		return userVo;
	}

	@Override
	public UserVo register(String telephone, String password) {
		long startTimestamp = System.currentTimeMillis();
		UserVo userVo = super.register(telephone, password);
		long endTimeStamp = System.currentTimeMillis();
		long responseTime = endTimeStamp - startTimestamp;
//		RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
//		metricsCollector.recordRequest(requestInfo);
		return userVo;
	}
}

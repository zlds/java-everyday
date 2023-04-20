package org.example.aop;

/**
 * @author: hanchaowei
 * @date 2023/4/20
 * @description:
 */

public class CglibProxyDemo {
	public static void main(String[] args) {
		CglibProxy cglibProxy = new CglibProxy();
		IMyCglibService myCglibService = (IMyCglibService) cglibProxy.getInstance(new IMyCglibServiceImpl());
		myCglibService.getMessage();
	}
}

package org.example.aop;

/**
 * @author: hanchaowei
 * @date 2023/4/18
 * @description:
 */

public class IMyAopServiceImpl implements IMyAopService {
	@Override
	public void getMessage() {
		System.out.println("Hello World!");
	}
}

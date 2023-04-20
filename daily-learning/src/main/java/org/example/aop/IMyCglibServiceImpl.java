package org.example.aop;

/**
 * @author: hanchaowei
 * @date 2023/4/20
 * @description:
 */

public class IMyCglibServiceImpl implements IMyCglibService {
	@Override
	public void getMessage() {
		System.out.println("getMessage");
	}
}

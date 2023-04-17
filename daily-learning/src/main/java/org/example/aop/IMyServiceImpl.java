package org.example.aop;

import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2023/4/17
 * @description:
 */

@Service
public class IMyServiceImpl implements IMyService {
	@Override
	public void getMessage() {
		System.out.println("Hello World!");
	}
}

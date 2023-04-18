package org.example.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: hanchaowei
 * @date 2023/4/18
 * @description:
 */
@Service
public class IMyAopServiceImpl implements IMyAopService {
	@Override
	public void getMessage() {
		System.out.println("Hello World!");
	}
}

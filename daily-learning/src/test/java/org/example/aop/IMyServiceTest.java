package org.example.aop;

import org.example.JavaEverydayApplication;
import org.example.aop.IMyService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = JavaEverydayApplication.class)
class IMyServiceTest {

	@Autowired
	private IMyService myService;

	@Test
	public void testAspect() {
		myService.getMessage();
	}

}
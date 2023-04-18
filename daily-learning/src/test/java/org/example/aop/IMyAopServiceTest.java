package org.example.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class IMyAopServiceTest {
	@Autowired
	IMyAopService iMyAopService;

	@Test
	public void getMessage() {
		iMyAopService.getMessage();
	}
}
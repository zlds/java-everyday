package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @author: hanchaowei
 * @date 2023/4/17
 * @description:
 */
@Aspect
@Component
public class MyAspect {

	/**
	 * 定义切点，匹配IMyService类的所有方法
	 */
	@Pointcut("execution(* org.example.aop.IMyService.*(..))")
	public void myServiceMethods() {
	}

	/**
	 * 环绕通知
	 * @param pointcut
	 * @return
	 * @throws Throwable
	 */
	@Around("myServiceMethods()")
	public Object aroundAdvice(ProceedingJoinPoint pointcut) throws Throwable {
		// 方法执行前
		System.out.println("Before method: " + pointcut.getSignature());
		// 调用目标方法
		Object result = pointcut.proceed();
		// 方法执行后
		System.out.println("After method: " + pointcut.getSignature());
		return result;
	}
}

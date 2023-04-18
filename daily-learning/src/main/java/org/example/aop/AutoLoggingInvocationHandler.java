package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author: hanchaowei
 * @date 2023/4/18
 * @description: 动态代理实现AOP，无需手动创建代理对象，也无需在调用方进行任何改动
 */

@Component
@Aspect
public class AutoLoggingInvocationHandler {
	@Around("execution(* org.example.aop.IMyAopService.*(..))")
	public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("====方法执行前获取请求信息=====");
		Object result = joinPoint.proceed();
		System.out.println("====方法请求后记录到db中====");
		return result;
	}



}

package org.example.gof.chainpattern.geektime;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: hanchaowei
 * @date 2023/5/21
 * @description:
 */

public class LogInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("拦截客户端发送的请求.");
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("这里总是被执行的.");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}

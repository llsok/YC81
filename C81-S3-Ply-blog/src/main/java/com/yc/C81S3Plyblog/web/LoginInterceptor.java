package com.yc.C81S3Plyblog.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 前置拦截  pre 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("loginedUser") == null) {
			response.sendRedirect("index?login=1");
			// false ==> 请求从此中断,不去访问 action
			return false;
		} else {
			// true ==> 去访问 action
			return true;
		}
	}
	
	
	
}

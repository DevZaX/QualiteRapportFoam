package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		System.err.println("mara min hona");
		return true;
//		if(request.getAttribute("mat") == null)
//		{
//			response.sendRedirect("test/1");
//			return false;
//		}
//		System.err.println("mara min hona");
//		return true;
	}

	
}

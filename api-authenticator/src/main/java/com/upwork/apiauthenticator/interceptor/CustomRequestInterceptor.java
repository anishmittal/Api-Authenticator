package com.upwork.apiauthenticator.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import com.upwork.apiauthenticator.util.Constants;
import com.upwork.apiauthenticator.util.Utility;

public class CustomRequestInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  throws Exception{
		boolean authenticated = Utility.validateAPIKey(request.getHeader(Constants.APIKEY));
		
		if(!authenticated) {
			response.getWriter().write("UNAUTHORIZED");
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;
		}
		else {
			return true;
		}
	}
}

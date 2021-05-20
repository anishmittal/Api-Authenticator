package com.upwork.apiauthenticator.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.upwork.apiauthenticator.interceptor.CustomRequestInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class APIConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	CustomRequestInterceptor interceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }

}

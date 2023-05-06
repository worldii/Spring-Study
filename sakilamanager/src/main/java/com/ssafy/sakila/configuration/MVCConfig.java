package com.ssafy.sakila.configuration;

import org.apache.catalina.filters.SessionInitializerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.sakila.interceptor.SessionInterceptor;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/admin/insert").setViewName("admin/insert");
		registry.addViewController("/admin/list").setViewName("admin/list");
		registry.addViewController("/admin/help").setViewName("admin/help");
	}
	/*
	 * /admin/list /insert /help
	 */

	@Autowired
	SessionInterceptor si;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(si).addPathPatterns("/admin/*")
		                           .excludePathPatterns("/admin/help");
	}

}

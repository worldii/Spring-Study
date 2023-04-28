package com.ssafy.sakila.configuration;

import javax.websocket.Session;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.sakila.interceptor.SessionInterceptor;

@Configuration
@MapperScan
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub

		registry.addViewController("/").setViewName("home");
		registry.addViewController("/admin/insert").setViewName("admin/insert");
		registry.addViewController("/admin/list").setViewName("admin/list");
		registry.addViewController("/admin/help").setViewName("admin/help");

	}

	@Autowired
	SessionInterceptor si;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(si).addPathPatterns("/admin/*").excludePathPatterns("/admin/help");

	}

}

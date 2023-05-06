package com.ssafy.mybatis.config;

import com.ssafy.mybatis.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// InterCeptor 는 추후 적용할 것임

//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SessionInterceptor())   //interceptor 등록
//                .order(1)   //우선도
//                .addPathPatterns("/**"); //사용될 url
////                .excludePathPatterns()    //제외될 url
//    }
//}

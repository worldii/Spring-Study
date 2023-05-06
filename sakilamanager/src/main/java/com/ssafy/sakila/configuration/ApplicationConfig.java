package com.ssafy.sakila.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import com.ssafy.sakila.model.mapper.CustomerMapper;

// 웹과 무관한 녀석
@Configuration
@MapperScan(basePackageClasses = CustomerMapper.class)
public class ApplicationConfig {

}

package com.ssafy.sakila.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import com.ssafy.sakila.model.mapper.CustomMapper;

@Configuration
@MapperScan(basePackageClasses = CustomMapper.class)
public class ApplicationConfig {

}

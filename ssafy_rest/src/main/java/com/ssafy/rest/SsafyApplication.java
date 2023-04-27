package com.ssafy.rest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ssafy.rest.model.mapper")
public class SsafyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsafyApplication.class, args);
	}

}

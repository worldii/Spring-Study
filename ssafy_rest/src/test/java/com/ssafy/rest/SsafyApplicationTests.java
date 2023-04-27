package com.ssafy.rest;

import com.ssafy.rest.model.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class SsafyApplicationTests {

	@Autowired
	DataSource ds;

	@Autowired
	CityMapper mapper;


	@Test
	@DisplayName("bean Not null 확인")
	void contextLoads() {

		assertNotNull(ds);
		log.info("{} test");
		assertNotNull(mapper);

	}

}

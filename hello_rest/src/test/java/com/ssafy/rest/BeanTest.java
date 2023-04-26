package com.ssafy.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.sql.DataSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ssafy.rest.model.dto.City;
import com.ssafy.rest.model.mapper.CityMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class BeanTest {

	@Autowired
	DataSource ds;

	@Autowired
	CityMapper mapper;

	@Test
	public void testDs() {
		assertNotNull(ds);
	}

	@Test
	public void testMapper() {
		assertNotNull(mapper);
	};

	

}

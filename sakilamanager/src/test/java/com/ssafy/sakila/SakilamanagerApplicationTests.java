package com.ssafy.sakila;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.sakila.model.mapper.CustomerMapper;

@SpringBootTest
class SakilamanagerApplicationTests {
	@Autowired
	DataSource ds;
	
	@Autowired
	CustomerMapper mapper;
	
	@Test
	public void customerMapperTest() {
		assertNotNull(mapper);
	}

	@Test
	void contextLoads() throws SQLException {
		assertNotNull(ds);
		Connection con = ds.getConnection();
		assertNotNull(con);
	}

}

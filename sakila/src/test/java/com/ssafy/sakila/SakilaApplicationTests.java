package com.ssafy.sakila;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.sakila.model.dto.Customer;
import com.ssafy.sakila.model.mapper.CustomMapper;
import com.ssafy.sakila.model.service.CustomerService;

@SpringBootTest
class SakilaApplicationTests {

	@Autowired
	DataSource ds;

	@Autowired
	CustomMapper mapper;

	@Test
	void contextLoads() throws SQLException {

		assertNotNull(ds);
		Connection con = ds.getConnection();
		assertNotNull(con);
	}

	@Test
	public void customerMapperTest() {
		assertNotNull(mapper);
	}

	@Test
	public void selectTest() {
		List<Customer> list = mapper.search();

		assertEquals(list.size(), 599);

		Customer c = list.get(0);

	}

	@Test
	public void selectTes2t() {
		// int customerId =
		String mail = "MARY.SMITH@sakilacustomer.org";
		Customer c = mapper.select(mail);

		assertEquals(c.getEmail(), "MARY.SMITH@sakilacustomer.org");

	}

	@Autowired
	CustomerService CustomerService;

	@Test
	public void testLogin() {

		String mail = "MARY.SMITH@sakilacustomer.org";
		Customer c = Customer.builder().email(mail).firstName("MARY").build();

		Customer select = CustomerService.login(c);

		assertEquals(select.getLastName(), "SMITH");

		c.setEmail("hello");
		select = CustomerService.login(c);
		assertNull(select);

	}
}

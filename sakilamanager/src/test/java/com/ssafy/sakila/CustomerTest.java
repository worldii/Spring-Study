package com.ssafy.sakila;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.sakila.model.dto.Customer;
import com.ssafy.sakila.model.mapper.CustomerMapper;
import com.ssafy.sakila.model.service.CustomerService;

@SpringBootTest
public class CustomerTest {
	@Autowired
	CustomerMapper mapper;

	@Test
	public void selectTest() {
		// given
		int customerId = 1;
		String email = "MARY.SMITH@sakilacustomer.org";
		// when
		Customer c = mapper.select(email);
		// then
		assertEquals(c.getCustomerId(), customerId);
		
	}

	@Test
	public void searchTest() {
		// given
		// when
		List<Customer> list = mapper.search();
		// then
		assertEquals(list.size(), 599);

		Customer c = list.get(0);
		assertEquals(c.getEmail(), "AUSTIN.CINTRON@sakilacustomer.org");
		

	}

	@Autowired
	CustomerService service;

	@Test
	public void testLogin() {
		String email = "MARY.SMITH@sakilacustomer.org";
		Customer c = Customer.builder().email(email).firstName("MARY").build();
		Customer selected = service.login(c);
		assertEquals(selected.getLastName(), "SMITH");

		c.setFirstName("wrong");
		selected = service.login(c);
		assertNull(selected);

		c.setEmail("dont exist");
		selected = service.login(c);
		assertNull(selected);
	}
}

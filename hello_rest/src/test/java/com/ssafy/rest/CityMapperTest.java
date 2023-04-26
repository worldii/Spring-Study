package com.ssafy.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.rest.model.dto.City;
import com.ssafy.rest.model.mapper.CityMapper;

public class CityMapperTest extends AbstractTest {

	@Autowired
	CityMapper mapper;

	@Test
	@DisplayName("select Test")
	public void selectTest() {

		int id = 1;
		City city = mapper.select(id);
		assertEquals(city.getName(), "Kabul");
	}

	@Test
	@Transactional
	@DisplayName("insert Test")
	public void insertTest() {
		City city = City.builder().countryCode("ABW").district("district").name("ds").population(12).build();
		int result = mapper.insert(city);
		assertEquals(result, 1);
	}

	@Test
	@Transactional
	@DisplayName("update Test")
	public void updateTest() {

		int id = 4080;
		City temp = mapper.select(id);
		temp.setName("hello");
		int result = mapper.update(temp);
		assertEquals(result, 1);
		
	}

	@Test
	@Transactional
	@DisplayName("delete Test")
	public void deleteTest() {
		int id = 4080;
		int result = mapper.delete(id);
		assertEquals(result, 1);
		City temp = mapper.select(id);
		assertNull(temp);
	}

}

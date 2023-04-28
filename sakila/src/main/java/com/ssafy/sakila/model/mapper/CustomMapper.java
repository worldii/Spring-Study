package com.ssafy.sakila.model.mapper;

import java.util.List;

import com.ssafy.sakila.model.dto.Customer;

public interface CustomMapper {

	Customer select (String email);
	List<Customer> search();
}

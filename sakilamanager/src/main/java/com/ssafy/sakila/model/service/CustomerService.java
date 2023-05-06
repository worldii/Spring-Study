package com.ssafy.sakila.model.service;

import java.util.List;

import com.ssafy.sakila.model.dto.Customer;

public interface CustomerService {

	// 사용자의 email을 id, firstName을 pass로 간주한다.
	Customer login(Customer customer);

	List<Customer> list();
}

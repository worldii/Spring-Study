package com.ssafy.sakila.model.service;

import java.util.List;

import com.ssafy.sakila.model.dto.Customer;

public interface CustomerService {

	Customer login(Customer customer);
	
	List<Customer> list();
}

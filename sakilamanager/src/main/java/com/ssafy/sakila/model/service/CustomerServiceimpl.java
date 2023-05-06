package com.ssafy.sakila.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.sakila.model.dto.Customer;
import com.ssafy.sakila.model.mapper.CustomerMapper;

@Service
public class CustomerServiceimpl implements CustomerService {

	private CustomerMapper mapper;

	@Autowired
	public CustomerServiceimpl(CustomerMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Customer login(Customer customer) {
		Customer selected = mapper.select(customer.getEmail());
		if (selected == null) {
			return null;
		}
		if (selected.getFirstName().equals(customer.getFirstName())) {
			return selected;
		} else {
			return null;
		}
	}

	@Override
	public List<Customer> list() {
		return mapper.search();
	}

}

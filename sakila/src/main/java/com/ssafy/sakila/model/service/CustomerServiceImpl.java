package com.ssafy.sakila.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sakila.model.dto.Customer;
import com.ssafy.sakila.model.mapper.CustomMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomMapper mapper;

	@Override
	public Customer login(Customer customer) {
		// TODO Auto-generated method stub
		Customer temp = mapper.select(customer.getEmail());

		if (temp == null) {
			return null;
		} else {
			if (temp.getFirstName().equals(customer.getFirstName()))
				return temp;
		}
		return null;
	}

	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		return mapper.search();
	}

}

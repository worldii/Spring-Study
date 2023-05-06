package com.ssafy.sakila.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.sakila.model.dto.Customer;
import com.ssafy.sakila.model.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
	private CustomerService service;

	public CustomerRestController(CustomerService service) {
		this.service = service;
	}

	// 사용자의 목록을 뿌려주고 싶어요!
	@GetMapping
	public List<Customer> list() {
		return service.list();
	}
}

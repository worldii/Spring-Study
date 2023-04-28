package com.ssafy.sakila.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.sakila.model.dto.Customer;
import com.ssafy.sakila.model.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	private final CustomerService CustomerService;

	// 사용자 목록을 보여주고 싶다.
	@GetMapping()
	public ResponseEntity<Map<String, Object>> getList() {
		Map<String, Object> result = new HashMap<>();

		List<Customer> list = CustomerService.list();
		result.put("customer", list);
		//result.put("ok", true);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

}

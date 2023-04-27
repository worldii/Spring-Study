package com.ssafy.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.model.dto.City;
import com.ssafy.rest.model.mapper.CityMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/city")
@CrossOrigin("*")

public class CityRestController {

	private final CityMapper CityMapper;

	// 모든 도시의 정보를 반환
	@GetMapping
	public List<City> list() {
		return CityMapper.search();
	}

	@GetMapping("/{id}")
	public City city(@PathVariable int id) {
		return CityMapper.select(id);
	}

	@PostMapping
	public City insert(@RequestBody City city) {
		CityMapper.insert(city);
		return city;
	}


	@GetMapping("/restest/{id}")
	public Map<String, Object> cityTest(@PathVariable int id) {
		Map<String, Object> result = new HashMap<>();

		if (id%2==0)
		{
			result.put("ok", true);
			result.put("data",CityMapper.select(id));
		}
		else {
			result.put("ok", false);
			result.put("data", "오늘은 홀수를 처리하기 싫다");
		}
		return result;
	}

	@GetMapping("/restest2/{id}")
	public ResponseEntity<Map<String, Object>> cityTest2(@PathVariable int id) {
		Map<String, Object> result = new HashMap<>();

		if (id%2==0)
		{
			result.put("ok", true);
			result.put("data",CityMapper.select(id));
			return new ResponseEntity<Map<String,Object >>(result, HttpStatus.OK);
		}
		else {
			result.put("ok", false);
			result.put("data", "오늘은 홀수를 처리하기 싫다");
			return new ResponseEntity<Map<String,Object >>(result, HttpStatus.NOT_FOUND);
		}

	}
}

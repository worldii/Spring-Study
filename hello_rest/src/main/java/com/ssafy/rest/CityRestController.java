package com.ssafy.rest;

import java.util.List;

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
}

package com.ssafy.rest.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.rest.model.dto.City;

@Mapper
public interface CityMapper {

	City select(int id);

	List<City> search();

	int insert(City city);

	int update(City city);

	int delete(int id);
}

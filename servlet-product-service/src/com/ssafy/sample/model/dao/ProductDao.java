package com.ssafy.sample.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Product;

public interface ProductDao {

	public int regist(Product product) throws SQLException;
	public List<Product> list() throws SQLException;
	public Product select(String code) throws SQLException;
	public int delete(String code) throws SQLException;

}

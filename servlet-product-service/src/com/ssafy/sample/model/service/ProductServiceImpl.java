package com.ssafy.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.dao.ProductDaoImpl;

public class ProductServiceImpl    {

	private  ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	private static ProductServiceImpl productServiceImpl =new ProductServiceImpl ();
	public static ProductServiceImpl getImpl() {
		return productServiceImpl;
		
	}
	public int regist(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return ProductDaoImpl.getImpl().regist( product);
	}

	public List<Product> list() throws SQLException {
		// TODO Auto-generated method stub
		return ProductDaoImpl.getImpl().list();
	}

	
	public Product select(String code) throws SQLException {
		// TODO Auto-generated method stub
		return ProductDaoImpl.getImpl().select(code);
	}

	public int delete(String code) throws SQLException {
		// TODO Auto-generated method stub
		return ProductDaoImpl.getImpl().delete(code);
	}

}

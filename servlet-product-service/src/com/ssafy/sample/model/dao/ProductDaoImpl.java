package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.util.DBUtil;

public class ProductDaoImpl implements ProductDao {
	private ProductDaoImpl() {
	}

	private static ProductDaoImpl productDaoImpl = new ProductDaoImpl();

	public static ProductDaoImpl getImpl() {
		return productDaoImpl;
	}

	@Override
	public int regist(Product product) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		Connection connection = null;
		StringBuilder sql = new StringBuilder();

		int result = -1;
		try {
			connection = DBUtil.getInstance().getConnection();

			sql.append("insert into product (code, model, price) values (? , ?, ?) ");

			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, product.getProductCode());
			pstmt.setString(2, product.getModel());
			pstmt.setInt(3, product.getPrice());
			result = pstmt.executeUpdate();

		} finally {
			// TODO: handle finally clause
			DBUtil.getInstance().close(pstmt, connection);
		}

		return result;
	}

	@Override
	public List<Product> list() throws SQLException {
		// TODO Auto-generated method stub

		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		StringBuilder sql = new StringBuilder();
		List<Product> list = null;

		try {

			connection = DBUtil.getInstance().getConnection();
			sql.append("select * from product");
			pstmt = connection.prepareStatement(sql.toString());

			rset = pstmt.executeQuery();

			list = new ArrayList<>();
			while (rset.next()) {
				String productCode = rset.getString("code");
				String model = rset.getString("model");
				int price = Integer.parseInt(rset.getString("price"));
				Product product = new Product(productCode, model, price);
				list.add(product);
			}

		} finally {
			// TODO: handle finally clause
			DBUtil.getInstance().close(rset, pstmt, connection);
		}
		return list;
	}

	@Override
	public Product select(String code) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		StringBuilder sql = new StringBuilder();

		Product product = null;
		try {

			connection = DBUtil.getInstance().getConnection();
			sql.append("select * from product where code = ?");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, code);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				product = new Product(rset.getString("code"), rset.getString("model"),
						Integer.parseInt(rset.getString("price")));
			}

		} finally {
			// TODO: handle finally clause
			DBUtil.getInstance().close(rset, pstmt, connection);
		}

		return product;
	}

	@Override
	public int delete(String code) throws SQLException {
		
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		StringBuilder sql = new StringBuilder();
		System.out.println(code);
		
		int result = -1;
		try {

			connection = DBUtil.getInstance().getConnection();
			sql.append("delete from product where code = ? ");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, code);
			result = pstmt.executeUpdate();
			
			System.out.print("delete 성공");

		} finally {
			// TODO: handle finally clause
			DBUtil.getInstance().close( pstmt, connection);
		}
		return result;
	}

}

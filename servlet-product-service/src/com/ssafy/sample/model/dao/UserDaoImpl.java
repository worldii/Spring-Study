package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.sample.dto.User;
import com.ssafy.sample.util.DBUtil;

public class UserDaoImpl implements UserDao {

	private UserDaoImpl(){}

	private static UserDaoImpl userDaoImpl = new UserDaoImpl();
	public static UserDaoImpl getImpl() {
		return userDaoImpl;
	}
	@Override
	public int login(User user) throws SQLException {
		// TODO Auto-generated method stub
		String userName =user.getUserName();
		String password =user.getPassword();

		ResultSet rset =null;
		PreparedStatement pstmt = null;
		Connection connection =null;
		
		StringBuilder sql =new StringBuilder();
		
		try {
			sql.append("select * from user where name = ? and password = ? "); 
			
			
			connection =DBUtil.getInstance().getConnection();
		
			pstmt =connection.prepareStatement(sql.toString());		
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			rset =pstmt.executeQuery();
			
			if (rset.next()) {
				return 1;	
			}
		} finally {
			DBUtil.getInstance().close(rset,pstmt,connection);
			// TODO: handle finally clause
		}
		
		return -1;
	}
	
}

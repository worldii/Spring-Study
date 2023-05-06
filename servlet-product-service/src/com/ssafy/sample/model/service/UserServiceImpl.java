package com.ssafy.sample.model.service;

import java.sql.SQLException;

import com.ssafy.sample.dto.User;
import com.ssafy.sample.model.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private UserServiceImpl() {
	}
	
	private static UserServiceImpl userServiceImpl = new UserServiceImpl();
	public static UserServiceImpl getImpl() {
		return userServiceImpl;
	}
	@Override
	public int login(User user) throws SQLException {
		// TODO Auto-generated method stub
		return UserDaoImpl.getImpl().login(user);
	}

}

package com.ssafy.sample.model.dao;

import java.sql.SQLException;

import com.ssafy.sample.dto.User;

public interface UserDao {
	public int login(User user) throws SQLException;

}

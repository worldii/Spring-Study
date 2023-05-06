package com.ssafy.sample.model.service;

import java.sql.SQLException;

import com.ssafy.sample.dto.User;

public interface UserService {

	public int login(User user) throws SQLException;
}

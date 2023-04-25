package com.ssafy.test.model.repo;

import java.sql.SQLException;

import com.ssafy.test.model.dto.UserInfoDto;

public interface UserRepo {
	public UserInfoDto select (String id) throws SQLException;
}

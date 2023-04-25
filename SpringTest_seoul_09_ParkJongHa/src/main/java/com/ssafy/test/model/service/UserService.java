package com.ssafy.test.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ssafy.test.model.dto.UserInfoDto;

@Service
public interface UserService {
	UserInfoDto login (UserInfoDto user) throws SQLException;
}

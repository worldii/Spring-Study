package com.ssafy.test.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ssafy.test.model.dto.UserInfoDto;
import com.ssafy.test.model.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepo repo;
	
	@Override
	public UserInfoDto login(UserInfoDto user) throws SQLException {
		UserInfoDto selected = repo.select(user.getUserId());
		if (user.getUserPw().equals(selected.getUserPw())) {
			return selected;
		} else {
			return null;
		}
	}
}

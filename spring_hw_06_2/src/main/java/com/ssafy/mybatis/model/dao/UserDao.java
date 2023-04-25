package com.ssafy.mybatis.model.dao;
import com.ssafy.mybatis.model.dto.User;

public interface UserDao {
	User select(String id);
}

package com.ssafy.mybatis.model.service;

import com.ssafy.mybatis.model.dao.UserDao;
import com.ssafy.mybatis.model.dto.User;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User join(User user) {
        User user1 = userDao.select(user.getId());
        if (user1 != null) {
            if (user1.getPass().equals(user.getPass())) return user1;
        }
        return null;
    }
}

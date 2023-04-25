package com.ssafy.test.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.test.model.dto.UserInfoDto;
import com.ssafy.util.DBUtil;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepo {

	private final DataSource ds;
	private final DBUtil util;

	@Override
	public UserInfoDto select(String id) throws SQLException {
		UserInfoDto user = null;
		String sql = "select * from user where userid=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				user = new UserInfoDto();
				user.setUserId(rset.getString("userid"));
				user.setName(rset.getString("name"));
				user.setPosition(rset.getString("position"));
				user.setRClass(rset.getInt("rclass"));
				user.setRName(rset.getString("rname"));
				user.setUserPw(rset.getString("userpw"));
			}
		} finally {
			util.close(rset, pstmt, con);
		}
		return user;
	}
}

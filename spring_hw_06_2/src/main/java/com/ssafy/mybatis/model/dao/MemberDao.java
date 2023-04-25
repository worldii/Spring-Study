package com.ssafy.mybatis.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mybatis.model.dto.Member;


@Mapper
public interface MemberDao {
	int joinMember(Member member);
	List<Member> listMember();
	Member select(String userId);
	Member selectDetail(String userId);

}

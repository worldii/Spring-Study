package spring_mybatis.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import spring_mybatis.model.dto.Member;

// 상징적으로 Mapper 임을 표시해준다. 
@Mapper
public interface MemberDao {

	int joinMember(Member memberDto) throws SQLException;

	List<Member> listMember() throws SQLException;

	Member select(String memberId) throws SQLException;
	
	Member selectDetail(String userId);
}

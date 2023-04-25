package spring_mybatis.model.dao;

import java.sql.SQLException;
import java.util.List;

import spring_mybatis.model.dto.Member;

public interface MemberDao {

	void joinMember(Member memberDto) throws SQLException;

	List<Member> listMember() throws SQLException;

	Member select(String memberId) throws SQLException;
}

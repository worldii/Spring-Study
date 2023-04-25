package spring_mybatis.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_mybatis.model.dto.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	private final String NAMESPACE = "spring_mybatis.model.dao.MamberDaoImpl.";

	@Autowired
	SqlSessionFactory Factory;

	@Override
	public void joinMember(Member memberDto) throws SQLException {
		// TODO Auto-generated method stub
		try (SqlSession session = Factory.openSession()) {
			session.insert(NAMESPACE + "joinMember", memberDto);
			session.commit();
		}

	}

	@Override
	public List<Member> listMember() throws SQLException {
		// TODO Auto-generated method stub
		try (SqlSession session = Factory.openSession()) {
			return session.selectList(NAMESPACE + "listMember");
		}
	}

	@Override
	public Member select(String memberId) throws SQLException {
		// TODO Auto-generated method stub
		try (SqlSession session = Factory.openSession()) {
			return session.selectOne(NAMESPACE + "select", memberId);
		}
	}

}

package spring_mybatis.model.dao;

import java.sql.SQLException;
import java.util.List;

//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring_mybatis.model.dto.Member;

// Repository 로 취급하지 않음. 
// Spring은 관심 갖지 않음. -> bean 등록 안되어 있기 때문에.
//@Repository
public class MemberDaoImpl implements MemberDao {

	// NameSpace 패키지 기준으로 만듦
	private final String NAMESPACE = "spring_mybatis.model.dao.MemberDaoImpl.";

	@Autowired
	SqlSessionTemplate session;

	// factory 를 injection 받을 필요 없다.
	// @Autowired
	// SqlSessionFactory Factory;

	// 매서드의 선언부만 보면은 충분히 유추할 수 있기 때문에 이를 굳이 쓸 필요가 없다.
	@Override
	public int joinMember(Member memberDto) throws SQLException {
		// TODO Auto-generated method stub
//		try (SqlSession session = Factory.openSession()) {
		int result = session.insert(NAMESPACE + "joinMember", memberDto);
		session.commit();
		return result;
		// }

	}

	@Override
	public List<Member> listMember() throws SQLException {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE + "listMember");
	}

	@Override
	public Member select(String memberId) throws SQLException {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE + "select", memberId);

	}

}

package spring.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import spring_mybatis.config.AppConfig;
import spring_mybatis.model.dao.MemberDao;
import spring_mybatis.model.dto.Board;
import spring_mybatis.model.dto.Member;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class MemberRepoTest {

	@Autowired
	MemberDao memberDao;

	@Test
	public void selectTest() throws SQLException {
		System.out.println(memberDao.getClass().getName());
		// given
		String userId = "ssafy";
		// when
		Member member = memberDao.select(userId);
		System.out.println(member.getUserName());
		// then
		assertEquals(member.getUserName(), "김싸피");
	}

	@Test
	@Transactional
	// TEST 에서는 백퍼센트 롤백
	// transactional manager appconfig 에다가 해줘야 함.
	public void insertTest() throws SQLException {
		// given
		Member member = Member.builder().userId("testid2").userName("username").userPwd("1234")
				.emailDomain("emailDomain").emailId("emailId").build();
		// when
		int result = memberDao.joinMember(member);
		// then
		assertEquals(result, 1);

	}

	@Test
	public void selectTest2() throws SQLException {
		// given
		String userId = "ssafy";
		// when
		Member member = memberDao.selectDetail(userId);
		List<Board> boards = member.getBoards();
		// then
		assertEquals(member.getUserName(), "김싸피");
		for (int i = 0 ; i< boards.size() ; i++) {
			System.out.println(boards.get(i));
		}
		assertTrue(boards.size() > 0);

	}

}

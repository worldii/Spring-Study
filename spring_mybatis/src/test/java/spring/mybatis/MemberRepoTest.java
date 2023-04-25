package spring.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import spring_mybatis.config.AppConfig;
import spring_mybatis.model.dao.MemberDao;
import spring_mybatis.model.dto.Member;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class MemberRepoTest {

	@Autowired
	MemberDao memberDao;

	@Test
	public void selectTest() throws SQLException {
		// given
		String userId = "ssafy";
		// when
		Member member = memberDao.select(userId);
		// then
		assertEquals(member.getUserName(), "김싸피");
	}
}

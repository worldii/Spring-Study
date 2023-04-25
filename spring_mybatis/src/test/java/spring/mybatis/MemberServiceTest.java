package spring.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import spring_mybatis.config.AppConfig;
import spring_mybatis.model.dto.Member;
import spring_mybatis.model.service.MemberServiceImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class MemberServiceTest {
	@Autowired
	MemberServiceImpl service;

	@Test
	@Transactional
	public void serviceTest() {

		Member newMem = Member.builder().userId("a" + System.currentTimeMillis()).userName("name").userPwd("1234")
				.emailDomain("abc").emailId("def").build();

		int i = 1/0;
		int result = service.addMember(newMem);
		assertEquals(result, 1);

	}

}

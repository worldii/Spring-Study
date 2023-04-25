package spring_mybatis.model.service;

import org.springframework.stereotype.Service;

import spring_mybatis.model.dao.BoardDao;
import spring_mybatis.model.dao.MemberDao;
import spring_mybatis.model.dto.Board;
import spring_mybatis.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	MemberDao mDao;
	BoardDao bDao;

	public MemberServiceImpl(MemberDao mDao, BoardDao bDao) {
		this.mDao = mDao;
		this.bDao = bDao;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addMember(Member member) {
		// TODO Auto-generated method stub
		int result = mDao.joinMember(member);
		bDao.insert(Board.builder().userId("ssafy").subject("환영").content("잘왔어").build());
		return result;
	}

}

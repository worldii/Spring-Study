package spring_mybatis.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring_mybatis.model.dao.BoardDao;
import spring_mybatis.model.dao.MemberDao;
import spring_mybatis.model.dto.Board;
import spring_mybatis.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService{

    MemberDao mDao;
    BoardDao bDao;

    public MemberServiceImpl(MemberDao mdao, BoardDao bdao) {
        this.mDao = mdao;
        this.bDao = bdao;
    }
    @Override
    @Transactional
    public int addMember(Member member) {
        int result = mDao.joinMember(member);
        bDao.insert(Board.builder().userId("ssafy").subject("환영").content("잘왔어").build());
        return result;
    }

}
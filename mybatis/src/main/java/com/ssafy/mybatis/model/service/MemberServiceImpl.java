package com.ssafy.mybatis.model.service;

import com.ssafy.mybatis.model.dao.BoardDao;
import com.ssafy.mybatis.model.dao.MemberDao;
import com.ssafy.mybatis.model.dto.Board;
import com.ssafy.mybatis.model.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService{

    private MemberDao memberDao;
    private BoardDao boardDao;

    @Autowired
    public MemberServiceImpl(MemberDao memberDao, BoardDao boardDao) {
        this.memberDao = memberDao;
        this.boardDao = boardDao;
    }

    @Override
    @Transactional
    public int joinMember(Member member) {
        int result = memberDao.joinMember(member);
        boardDao.insert(Board.builder().userId("ssafy").subject("welcome").content("OK?").build());

        return result;
    }
}

package com.ssafy.mybatis;

import com.ssafy.mybatis.model.dao.BoardDao;
import com.ssafy.mybatis.model.dao.MemberDao;
import com.ssafy.mybatis.model.dto.Board;
import com.ssafy.mybatis.model.dto.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    BoardDao boardDao;

    @Autowired
    MemberDao memberDao;

    @Test
    @DisplayName("testBoarDao")
    void testBoardDao() {
        assertNotNull(boardDao);
    }

    @Test
    @DisplayName("testSelect")
    void testSelect(){
        Board board = boardDao.selectByArticleNo(1);

//        assertEquals(board.getSubject(),"ssafy");
    }

    @Test
    void testSelectMember(){
        Member member = memberDao.select("ssafy");
        System.out.println("member = " + member);
    }

    @Test
    @DisplayName("testSelect")
    void testSelectWithMember(){
        Board board = boardDao.selectDetailByArticleNo(1);

//        assertEquals(board.getSubject(),"ssafy");
//        assertEquals(board.getMember().getUserId(),"ssafy");
    }

    @Test
    @DisplayName("testSelect")
    @Transactional
    void testInsert(){
        Board board = Board.builder().userId("ssafy").subject("ssafy").content("content").build();
        int result = boardDao.insert(board);
        assertEquals(1,result);

        int articleNo = board.getArticleNo();

    }


    @Test
    @DisplayName("testSelect")
    void testSelecDetailMember(){
        Member member = memberDao.selectDetail("ssafy");
        List<Board> boards = member.getBoards();
        for(Board board: boards) {
            System.out.println(board);
        }
        assertEquals(member.getBoards().size(),2);
    }

    @Test
    @DisplayName("testSelect")
    void testSelectLawBoard(){
        Map<String,Object> map = new HashMap<>();
        map.put("articleNo",1);

        Map<String, Object> board = boardDao.selectLaw(map);
        System.out.println(board);
    }

    @Test
    void testTrim(){
        Map<String,Object> map = new HashMap<>();
        map.put("articleNo",1);
        List<Board> list = boardDao.searchTrim(map);

        System.out.println(list);
    }
}

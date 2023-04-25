package spring.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import spring_mybatis.config.AppConfig;
import spring_mybatis.model.dao.BoardDao;
import spring_mybatis.model.dto.Board;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class BoardRepotest {

	@Autowired
	BoardDao dao;

	@Test
	@DisplayName("select 테스트 되는지 확인")
	public void selectTest() {
		//
		int articleNo = 1;
		Board board = dao.select(articleNo);
		System.out.println(board.getUserId());
		assertEquals(board.getUserId(), "admin");

		//
		articleNo = 6;
		board = dao.select(articleNo);
		assertNull(board);
	}

	@Test
	@DisplayName("show list test")
	public void showListTest() {
		List<Board> list = dao.search();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		assertEquals(4, list.size());
	}

	@Test
	@Transactional
	@DisplayName("insert test")
	public void intserTest() {
		// given
		Board newBoard = Board.builder().content("content").hit(0).subject("제목").userId("ssafy").build();

		int result = dao.insert(newBoard);

		assertEquals(result, 1);
		System.out.println(newBoard.getArticleNo());
	}

	@Test
	@Transactional
	@DisplayName("update Test")
	public void updateTest() {
		// given

		Board updateBoard = Board.builder().content("contentUpdate").subject("hello").articleNo(1).build();
		// when
		int result = dao.update(updateBoard);
		// then
		assertEquals(result, 1);

		Board selecBoard = dao.select(updateBoard.getArticleNo());
		assertEquals(updateBoard.getContent(), selecBoard.getContent());
	}

	@Test
	@Transactional
	@DisplayName("delete Test")
	public void deleteTest() {
		// given
		Board newBoard = Board.builder().content("content").hit(0).subject("제목").userId("ssafy").build();

		dao.insert(newBoard);
		int articleNo = newBoard.getArticleNo();
		// when
		int result = dao.delete(articleNo);
		Board select = dao.select(articleNo);
		assertNull(select);

		/// then
	}

}

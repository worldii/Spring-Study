package spring_mybatis.model.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import spring_mybatis.model.dto.Board;

@Mapper
public interface BoardDao {
	Board select(int articleNo);

	// Board 와 함께 board의 작성자 member의 정보까지 조회.
	Board selectDetail(int articleNo);

	List<Board> search();

	int insert(Board board);

	int update(Board board);

	int delete(int articleNo);
}

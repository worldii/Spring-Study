package spring_mybatis.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import spring_mybatis.model.dto.Board;

@Mapper
public interface BoardDao {
	Board select(int articleNo);

	Map<String, Object> map = new HashMap<String, Object>();

	// Board 와 함께 board의 작성자 member의 정보까지 조회.
	Board selectDetail(int articleNo);

	Map<String, Object> selectLaw(Map<String, Object> map);

	List<Board> search();

	List<Board> searchIf(Map<String, Object> condition);

	List<Board> searchTrim(Map<String, Object> condition);

	List<Board> under(int articleNo);

	int insert(Board board);

	int update(Board board);

	int delete(int articleNo);
}

package com.ssafy.mybatis.model.dao;

import com.ssafy.mybatis.model.dto.Board;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
    Board selectByArticleNo(int articleNo);
    Board selectDetailByArticleNo(int articleNo);

    Map<String,Object> selectLaw(Map<String, Object> condition);

    List<Board> searchIf(Map<String,String> condition);
    List<Board> searchTrim(Map<String,Object> condition);
    List<Board> search();
    List<Board> under(int articleNo);
    List<Board> pattern(String condition);
    
    int insert(Board board);
    int update(Board board);
    int delete(int articleNo);

}

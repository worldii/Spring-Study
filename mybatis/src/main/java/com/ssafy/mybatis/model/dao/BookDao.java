package com.ssafy.mybatis.model.dao;

import com.ssafy.mybatis.model.dto.Book;

import java.util.List;

public interface BookDao {
	int insert(Book book);

	int update(Book book);

	int delete(String isbn);

	Book select(String isbn);

	List<Book> selectAll();
}

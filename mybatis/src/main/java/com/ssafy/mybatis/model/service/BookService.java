package com.ssafy.mybatis.model.service;

import com.ssafy.mybatis.model.dao.BookDao;
import com.ssafy.mybatis.model.dto.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookDao bookDao;

    public int insert(Book book) {
        return bookDao.insert(book);
    }

    public int update(Book book) {
        return bookDao.update(book);
    }

    public int delete(String isbn) {
        return bookDao.delete(isbn);
    }

    public Book select(String isbn) {
        return bookDao.select(isbn);
    }

    public List<Book> selectAll() {
        return bookDao.selectAll();
    }
}

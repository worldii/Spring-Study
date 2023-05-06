package com.ssafy.mybatis;

import com.ssafy.mybatis.model.dto.Book;
import com.ssafy.mybatis.model.service.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MybatisApplication.class)
public class BookRepoTest {

    @Autowired
    BookService bookService;

    @Test
    @DisplayName("select 잘되는지 확인")
    public void selectTest() {
        String isbn = "111-000-0001";
        Book tmp = bookService.select(isbn);
        assertEquals(isbn, tmp.getIsbn());
    }

    @Test
    @DisplayName("update 잘되는지 확인")
    @Transactional
    public void updateTest() {
        // given
        Book book = new Book();
        String isbn = "111-000-0001";

        book.setContent("변경했어요!");
        book.setAuthor("hello");
        book.setImg("null");
        book.setIsbn(isbn);
        book.setTitle("hello~");
        // when
        Book tmp = bookService.select(isbn);
        int result = bookService.update(book);

        // then
        assertEquals(1, result);
        assertNotEquals(tmp.getContent(), book.getContent());
    }

    @Transactional
    @Test
    @DisplayName("delete Test")
    public void deleteTest() {
        // given
        String isbn = "111-000-0001";

        // when
        int result = bookService.delete(isbn);

        // then
        assertEquals(result, 1);
        Book tmp = bookService.select(isbn);
        assertNull(tmp);
    }
}

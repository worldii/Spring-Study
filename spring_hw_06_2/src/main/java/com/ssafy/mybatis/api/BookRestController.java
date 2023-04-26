package com.ssafy.mybatis.api;

import com.ssafy.mybatis.model.dto.Book;
import com.ssafy.mybatis.model.dto.ResultCode;
import com.ssafy.mybatis.model.dto.ResultResponse;
import com.ssafy.mybatis.model.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@Slf4j

public class BookRestController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<ResultResponse> list() {
        List<Book> books = bookService.selectAll();
        log.info("{} books List GET API");
        return ResponseEntity.ok(new ResultResponse(ResultCode.GET_BOOKS_SUCCESS, books));
    }

    @PostMapping
    public ResponseEntity<ResultResponse> register(@RequestBody Book book) {
        int insert = bookService.insert(book);
        if (insert != 1) throw new RuntimeException();
        return ResponseEntity.ok(new ResultResponse(ResultCode.REGISTER_BOOK_SUCCESS, insert));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultResponse> select(@PathVariable String id) {
        Book select = bookService.select(id);
        if (select == null) throw new RuntimeException();
        return ResponseEntity.ok(new ResultResponse(ResultCode.GET_BOOK_SUCCESS, select));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultResponse> update(@PathVariable String id, @RequestBody Book book) {
        book.setIsbn(id);
        int update = bookService.update(book);
        if (update != 1) throw new RuntimeException();
        return ResponseEntity.ok(new ResultResponse(ResultCode.UPDATE_BOOK_SUCCESS, update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResultResponse> delete(@PathVariable String id) {
        int delete = bookService.delete(id);
        if (delete != 1) throw new RuntimeException();
        return ResponseEntity.ok(new ResultResponse(ResultCode.DELETE_BOOK_SUCCESS, delete));
    }
}

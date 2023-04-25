package com.ssafy.test.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.test.model.dto.AttendanceDto;
import com.ssafy.test.model.repo.AttendanceRepo;
import com.ssafy.test.model.service.AttendanceService;
import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/attendance")
@Slf4j
public class AttendanceController {
	private final AttendanceService attendanceService;
//
//	@GetMapping("/list")
//	public String list(Model model) throws SQLException {
//		List<U> list = attendanceService.search();
//		model.addAttribute("list", list);
//		return "book/list";
//	}
//
//	@GetMapping("/regist")
//	public String regist() throws SQLException {
//		return "book/regist";
//	}
//
//	@PostMapping("/regist")
//	public String regist(@ModelAttribute AttendanceDto book, Model model) throws SQLException {
//		attendanceService.insert(book);
//		model.addAttribute("book", book);
//		return "book/regist_result";
//	}
//
//	@GetMapping("/detail")
//	public String detail(@RequestParam String isbn, Model model) throws SQLException {
//		Book selected = attendanceService.select(isbn);
//		model.addAttribute("book", selected);
//		return "book/detail";
//	}
//
//	@GetMapping("/delete")
//	public String delete(@RequestParam String isbn) throws SQLException {
//		service.delete(isbn);
//		return "redirect:/book/list";
//	}
}

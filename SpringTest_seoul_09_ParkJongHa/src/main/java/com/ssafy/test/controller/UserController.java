package com.ssafy.test.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.test.model.dto.UserInfoDto;
import com.ssafy.test.model.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	@PostMapping("/login")
	public String login(@ModelAttribute UserInfoDto user, HttpSession session, Model model) throws SQLException {
		
		UserInfoDto loginUser = userService.login(user);
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			log.info("login 성공: {}", loginUser);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "로그인 실패, 정보 확인");
			log.info("login 실패: {}", user);
			return "index";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("logout");
		session.invalidate();
		return "redirect:/";
	}
	
}

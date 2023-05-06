package com.ssafy.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/join")
	public String join() {
		return "user/join";
	}

	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) throws Exception {
		log.debug("memberDto"+ memberDto);
		memberService.joinMember(memberDto);
		return "redirect:/";
	}

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("userid") String userId, @RequestParam("userpwd") String userPwd,
			HttpSession httpSession, Model model) throws Exception {
		MemberDto memberDto = memberService.loginMember(userId, userPwd);
		if (memberDto == null) {
			model.addAttribute("msg", "아이디 또는 비밀번호 확인하세요");
			return "user/login";

		} else {
			httpSession.setAttribute("userinfo", memberDto);
			return "redirect:/";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
	}
}

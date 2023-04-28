package com.ssafy.sakila.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.sakila.model.dto.Customer;
import com.ssafy.sakila.model.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class CustomerController {

	private final CustomerService service;

	@PostMapping("/login")
	public String login(@ModelAttribute Customer customer, HttpSession httpSession, Model model, RedirectAttributes redirectAttributes) {
		Customer loginUser = service.login(customer);
		if (loginUser != null) {
			httpSession.setAttribute("loginUser", loginUser);
			redirectAttributes.addFlashAttribute("msg", "로그인 되었습니다");
			return "redirect:/";
		} else {

			// request scope
			model.addAttribute("msg", "로그인 실패");
			return "home";
		}
	}
	
	@GetMapping("/logout") 
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
		
		
	}
}

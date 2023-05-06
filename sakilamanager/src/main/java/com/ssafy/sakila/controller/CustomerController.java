package com.ssafy.sakila.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.sakila.model.dto.Customer;
import com.ssafy.sakila.model.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@PostMapping("/user/login")
	public String login(@ModelAttribute Customer customer, HttpSession session, Model model,
			RedirectAttributes redirAttr) {
		Customer loginUser = service.login(customer);
		log.debug("param customer: {}, loginUser: {}", customer, loginUser);
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			// session.setAttribute("msg", "환영"); // forward -> request
			// 1회성 session
			redirAttr.addFlashAttribute("msg", "로그인 되었습니다.");
			return "redirect:/"; // request X,
		} else {
			model.addAttribute("msg", "로그인 실패"); // forward -> request
			return "home";
		}
	}

	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	

}
/*
 /admin/list
       /insert
       /help
 
 */
package com.ssafy.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;
import com.ssafy.util.PageNavigation;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	@GetMapping("/write")
	public String write(@RequestParam Map<String, String> map, Model model) {
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "board/write";
	}

	@PostMapping("/write")
	public String write(BoardDto boardDto, HttpSession httpSession, RedirectAttributes redirectAttributes)
			throws Exception {
		MemberDto memberDto = (MemberDto) httpSession.getAttribute("userinfo");
		boardDto.setUserId(memberDto.getUserId());
		boardService.writeArticle(boardDto);

		// redirect 할때는 redirect Attribute
		redirectAttributes.addAttribute("pgno", "1");
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");

		// 보이지 않게 넘김
// 		redirectAttributes.addFlashAttribute(attributeValue)
		return "redirect:/article/list";
	}

	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<BoardDto> list = boardService.listArticle(map);
		PageNavigation pageNavigation = boardService.makePageNavigation(map);
		// forward 할때는 MODEL
		mav.addObject("articles", list);
		mav.addObject("navigation", pageNavigation);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("/board/list");
		return mav;
	}

	@GetMapping("/view")
	public String view(Model model, @RequestParam int articleno) throws Exception {
		BoardDto boardDto = boardService.getArticle(articleno);
		model.addAttribute("article", boardDto);
		return "board/view";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam int articleno, RedirectAttributes redirectAttributes) throws Exception {
		boardService.deleteArticle(articleno);
		// redirect 할때는 redirect Attribute
		redirectAttributes.addAttribute("pgno", "1");
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
		return "redirect:/article/list";
	}

	@GetMapping("/modify")
	public String modify(@RequestParam int articleno, Model model) throws Exception {

		BoardDto boardDto = boardService.getArticle(articleno);
		model.addAttribute("article", boardDto);

		return "board/modify";
	}

	@PostMapping("/modify")
	public String modify(@RequestParam int articleno, BoardDto boardDto, RedirectAttributes redirectAttributes)
			throws Exception {
		boardDto.setArticleNo(articleno);
		boardService.modifyArticle(boardDto);
		redirectAttributes.addAttribute("articleno", articleno);
		return "redirect:/article/view";
	}
}

package com.jongeon.mybatisboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jongeon.mybatisboard.service.PostService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Controller
public class HomeController {
	private PostService postService;
//	@GetMapping("/")
//	public String index() {
//
//		System.out.println("홈 컨트롤러 테스트");
//		return "index.html";
//	} 
	
	// 게시글 목록 페이지로 이동
	@GetMapping("/")
	public String signUpPage(Model model) {
		
		
		model.addAttribute("postList", postService.postList());
		
		return "board/post/postListPage.html";
	}
}

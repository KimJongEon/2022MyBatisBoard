package com.jongeon.mybatisboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jongeon.mybatisboard.service.PostService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class PostController {
	private PostService postService;
	
	//글 상세 페이지로 이동
	@GetMapping("/postDetailPage/{postNumber}")
	public String postDetailPage(
			Model model,
			@PathVariable("postNumber") Long postNumber
			) {
		
		//PathVariable을 통해 받아온 postNumber를 사용
		//해당 postNumber에 대한 글 정보를 가져온다
		model.addAttribute("postDetail", postService.postDetail(postNumber));
		return "board/post/postDetailPage.html";
	}
}

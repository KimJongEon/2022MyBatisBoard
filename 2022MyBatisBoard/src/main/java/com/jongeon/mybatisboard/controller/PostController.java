package com.jongeon.mybatisboard.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jongeon.mybatisboard.domain.PostVO;
import com.jongeon.mybatisboard.domain.SecurityMember;
import com.jongeon.mybatisboard.service.PostService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class PostController {
	private PostService postService; // post와 관련된 서비스
	
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
	
	//글 쓰기 페이지로 이동
	@GetMapping("/postRegisterPage")
	public String postRegisterPage() {
		
		return "board/post/postRegisterPage.html";
	}
	
	// 글 등록
	@PostMapping("/postRegister")
	public String postRegister(PostVO postVO,
			// @AuthenticationPrincipal 로그인한 유저의 정보를 세션에 담고 필요할때 꺼내어 씀
			// 해당 유저 정보가 필요할 때마다 DB에 접속할 필요가 없음
			@AuthenticationPrincipal SecurityMember securityMember
			) {
//		Long GetPostNumber = (long) 0;
//		GetPostNumber = postService.getPostNumber();
		
		// 빌더패턴으로 PostVO 값을 담아서 postService.postRegister(postVO) 실행
		postVO = PostVO.builder()
//				.postNumber(GetPostNumber + 1)
				.mbrIdx(securityMember.getMemberVO().getMbrIdx()) // securityMember에서 가져온 mbrIdx 값을 PostVO의 mbrIdx에 값을 담는다 
				.postTitle(postVO.getPostTitle())
				.postContent(postVO.getPostContent())
				.build();
		
		// postService의 글 등록 메소드 실행
		Long postRegister = postService.postRegister(postVO);
		
		
		System.out.println(postVO.getPostNumber());
		return "redirect:/";
	}
}

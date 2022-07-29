package com.jongeon.mybatisboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jongeon.mybatisboard.domain.SecurityMember;
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
	public String signUpPage(
			HttpServletRequest request,
			Model model,
			@AuthenticationPrincipal SecurityMember securityMember
			) {
		if(securityMember != null) {
			String mbrNickName = securityMember.getMemberVO().getMbrNickName();
			System.out.println(mbrNickName);
			HttpSession session = request.getSession();
			if(session != null) {
				session.setAttribute("getMbrNickName", mbrNickName);
//				session.setAttribute("b", "hi"); // 더 저장하고 싶으면 setAttribute 추가
				} // session if End
		} // securityMember if End
		
		model.addAttribute("postList", postService.postList());
		
		return "board/post/postListPage.html";
	}
}

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
		// 로그인 유무 판단을 위해 null 체크
		if(securityMember != null) {
			// securityMember 에서 mbrNickName, mbrEmail 가져온다
			String mbrNickName = securityMember.getMemberVO().getMbrNickName();
			Long mbrIdx = securityMember.getMemberVO().getMbrIdx();
//			System.out.println(mbrNickName); // 닉네임 가져오는지 확인
//			System.out.println(mbrIdx);
			HttpSession session = request.getSession();
			// 세션 null 체크
			if(session != null) {
				session.setAttribute("getMbrNickName", mbrNickName);
				session.setAttribute("getMbrIdx", mbrIdx);	
				} // session if End
		} // securityMember if End
		
		model.addAttribute("postList", postService.postList());
		
		return "board/post/postListPage.html";
	}
}

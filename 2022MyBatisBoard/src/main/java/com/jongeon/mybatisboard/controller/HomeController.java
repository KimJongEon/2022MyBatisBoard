package com.jongeon.mybatisboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jongeon.mybatisboard.domain.PagingVO;
import com.jongeon.mybatisboard.domain.SecurityMember;
import com.jongeon.mybatisboard.service.PostService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Controller
public class HomeController {
	private PostService postService;
	
	//  ##### 게시글 목록 페이지로 이동 #####
	@GetMapping("/")
	public String postListPage(
			HttpServletRequest request,
			Model model,
			@RequestParam(required = false, defaultValue = "1") int page, // 페이징 처리
			@RequestParam(required = false, defaultValue = "1") int range, // 페이징 처리 
			@AuthenticationPrincipal SecurityMember securityMember
			) {
		if(securityMember != null) { // 로그인 유무 판단을 위해 null 체크
			// securityMember 에서 mbrNickName, mbrEmail 가져온다
			String mbrNickName = securityMember.getMemberVO().getMbrNickName();
			Long mbrIdx = securityMember.getMemberVO().getMbrIdx();
			HttpSession session = request.getSession();
			if(session != null) { // 세션 null 체크
				session.setAttribute("getMbrNickName", mbrNickName);
				session.setAttribute("getMbrIdx", mbrIdx);	
				} // session if End
		} // securityMember if End

		int postListCnt = postService.postListCnt();//전체 게시글 개수 가져오기
		
		PagingVO pagingVO = new PagingVO();
		pagingVO.pageInfo(page, range, postListCnt);
		
		
		// 페이징 처리
		model.addAttribute("pagingVO", pagingVO);
		model.addAttribute("postList", postService.postList(pagingVO));
		return "board/post/postListPage.html";
	}
}

package com.jongeon.mybatisboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jongeon.mybatisboard.domain.PostVO;
import com.jongeon.mybatisboard.domain.SecurityMember;
import com.jongeon.mybatisboard.service.PostService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class PostController {
	private PostService postService; // post와 관련된 서비스
	
	// ##### 글 상세 페이지로 이동 #####
	@GetMapping("/postDetailPage/{postNumber}")
	public String postDetailPage(
			Model model,
			@PathVariable("postNumber") Long postNumber
			) {
		
		//해당 글 조회수 증가
		postService.updateReadCnt(postNumber);
		
		//PathVariable을 통해 받아온 postNumber를 사용
		//해당 postNumber에 대한 글 정보를 가져온다
		model.addAttribute("postDetail", postService.postDetail(postNumber));
		return "board/post/postDetailPage.html";
	}
	
	// ##### 글 쓰기 페이지로 이동 #####
	@GetMapping("/postRegisterPage")
	public String postRegisterPage(@AuthenticationPrincipal SecurityMember securityMember) {
		if(securityMember != null) {
			return "board/post/postRegisterPage.html";
		}else {
			return "redirect:/loginPage";
		}
	} //postRegisterPage End
	
	// ##### 글 등록 #####
	@PostMapping("/postRegister")
	public String postRegister(PostVO postVO,
//			Model model,
			// @AuthenticationPrincipal 로그인한 유저의 정보를 세션에 담고 필요할때 꺼내어 씀
			// 해당 유저 정보가 필요할 때마다 DB에 접속할 필요가 없음
			@AuthenticationPrincipal SecurityMember securityMember // User를 extends한 SecurityMember class 이용
			) {
		Long postNumber = (long) 0; // 작성할 글의 postNumber 변수 선언
		postNumber = postService.findPostNumber().getPostNumber() + 1; // 글 목록 중 제일 최신 글의 postNumber에 +1을 한 후 postNumber라는 변수에 담는다
		
		// 빌더패턴으로 PostVO 값을 담아서 postService.postRegister(postVO) 실행
		postVO = PostVO.builder()
				.postNumber(postNumber) // 작성 할 글의 postNumber 값 지정
				.mbrIdx(securityMember.getMemberVO().getMbrIdx()) // securityMember에서 가져온 mbrIdx 값을 PostVO의 mbrIdx에 값을 담는다 
				.postTitle(postVO.getPostTitle())
				.postContent(postVO.getPostContent())
				.build();
		
		// postService의 글 등록 메소드 실행
		Long postRegister = postService.postRegister(postVO);
		
		System.out.println(postVO.getPostNumber());
		return "redirect:/postDetailPage/" + postNumber; // 작성한 글의 상세페이지로 이동
	} // postRegister End
	
	// ##### 글 삭제 #####
	@GetMapping("/postDel")
	public String postDel(@RequestParam Long postNumber,
			HttpServletRequest request) {
//		System.out.println("Post컨트롤러 : "+postNumber); // view에서 컨트롤러로 넘오는지 확인
		
		HttpSession session = request.getSession();
		if(session == null) { // 세션이 null일 경우 바로 홈 화면으로 redirect 
			return "redirect:/";
		}else {
			postService.postDel(postNumber); // postService의 글 삭제 메소드 실행
			return "redirect:/";
		}
	} // postDel End
	
	
	// ##### 글 수정 페이지로 이동 #####
	@GetMapping("/postEditPage")
	public String postEditPage(@RequestParam Long postNumber,
			Model model) {
		System.out.println("Post컨트롤러 : "+postNumber); // view에서 컨트롤러로 넘오는지 확인
		
		//해당 postNumber에 대한 글 정보를 가져온다
		model.addAttribute("postDetail", postService.postDetail(postNumber));
		
		return "board/post/postEditPage.html";
	}// postEditPage End
	
	// ##### 글 수정 #####
	@PostMapping("/postEdit")
	public String postEdit(PostVO postVO,
			HttpServletRequest request,
			@AuthenticationPrincipal SecurityMember securityMember,
			Model model
			){
		Long postNumber = postVO.getPostNumber(); // 해당 글 번호
		String postTitle = postVO.getPostTitle(); // 글 제목
		String postContent = postVO.getPostContent(); // 글 내용
		
		// 로그인 정보가 null일때
		if(securityMember == null) {
			return "redirect:/";
		}else{
			//글 수정
			postService.postEdit(postNumber, postTitle, postContent);
			
			// 해당 글 정보 model에 저장
			model.addAttribute("postDetail", postService.postDetail(postNumber));			
			
			// 해당 글로 redirect
			return "redirect:/postDetailPage/" + postNumber;
		}
		
	} // postEdit End
}

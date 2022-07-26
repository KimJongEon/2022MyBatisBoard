package com.jongeon.mybatisboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jongeon.mybatisboard.domain.MemberVO;
import com.jongeon.mybatisboard.service.SignUpService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class SignUpController {
		private SignUpService signUpService;
	
		// 회원가입 페이지로 이동
		@GetMapping("/signUpPage")
		public String signUpPage() {
			return "board/signup/signUpPage.html";
		}
			
		// ########## 회원가입  ##########
		@PostMapping("/signUp") //view단(form태그) 에서 /signUp으로 보낸걸 컨트롤러에서 받음
		public String signUp(MemberVO memberVO, HttpServletRequest request) { // 회원가입 Dto 선언
			
			// 회원가입 서비스
			Long signUp = signUpService.signUp(memberVO);
		
			
			return "redirect:/signUpPage";
//			return "/board/login/logInPage.html";
		} //signUp End
}

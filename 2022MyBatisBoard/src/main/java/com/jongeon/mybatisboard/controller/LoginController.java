package com.jongeon.mybatisboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class LoginController {
	
	// ##### 로그인 페이지 이동 #####
	@GetMapping("/loginPage")
	public String loginPage() {
		
		return "board/login/loginPage.html";
	}
	
	// ▼▼▼▼▼ 로그인, 로그아웃 기능 ▼▼▼▼▼
	
	// *Spring Security에서 로그인, 로그아웃에 해당하는 URL 가로채기 때문에 컨트롤러 구현 불필요	
	// *SecurityConfig 참고
	
	// ▲▲▲▲▲ 로그인, 로그아웃 기능 ▲▲▲▲▲
}

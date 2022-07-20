package com.jongeon.mybatisboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {

		System.out.println("홈 컨트롤러 테스트");
		return "index.html";
	} 
}

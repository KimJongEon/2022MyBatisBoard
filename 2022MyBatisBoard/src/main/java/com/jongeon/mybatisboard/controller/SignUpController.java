package com.jongeon.mybatisboard.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jongeon.mybatisboard.domain.MemberVO;
import com.jongeon.mybatisboard.service.SignUpService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class SignUpController {
	private SignUpService signUpService; // 회원가입 서비스

	// 회원가입 페이지로 이동
	@GetMapping("/signUpPage")
	public String signUpPage() {
		return "board/signup/signUpPage.html";
	}

	// ########## 회원가입 ##########
	@PostMapping("/signUp") // view단(form태그) 에서 /signUp으로 보낸걸 컨트롤러에서 받음
	public String signUp(MemberVO memberVO, HttpServletResponse response) throws IOException { // 회원가입 Dto 선언
		String mbrEmail = memberVO.getMbrEmail();
		// null을 받아들일 수 있는 객체타입으로 바꿔준다. long or int → Integer
		Long mbrEmailCheck = signUpService.mbrEmailCheck(mbrEmail);

		if (mbrEmailCheck == 0 || mbrEmailCheck == null) { // 중복이 아닐 때
			// signUpService의 회원가입 메소드 실행
			Long signUp = signUpService.signUp(memberVO);

			return "redirect:/loginPage";
		} else {
			// out.print 사용을 위해 선언
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('존재하지 않는 사용자입니다.');");
			out.print("location.href='/loginPage' ");
			out.print("</script>");

			return "redirect:/signUpPage";
		}
	} // signUp End

	// mbrEmail 중복 체크
	@ResponseBody
	@GetMapping("/mbrEmailCheck")
	public String mbrEmailCheck(MemberVO memberVO) {
		String mbrEmail = memberVO.getMbrEmail();

		// null을 받아들일 수 있는 객체타입으로 바꿔준다. long or int → Integer
		Long mbrEmailCheck = signUpService.mbrEmailCheck(mbrEmail);
		if (mbrEmailCheck == 0 || mbrEmailCheck == null) { // 중복이 아닐 때
			return "success";
		} else {
			return "fail";
		}
	} // mbrEmailCheck End

	// mbrNickName 중복 체크
	@ResponseBody
	@GetMapping("/mbrNickNameCheck")
	public String mbrNickNameCheck(MemberVO memberVO) {
		String mbrNickName = memberVO.getMbrNickName();

		// null을 받아들일 수 있는 객체타입으로 바꿔준다. long or int → Integer
		Long mbrNickNameCheck = signUpService.mbrNickNameCheck(mbrNickName);
		if (mbrNickNameCheck == 0 || mbrNickNameCheck == null) { // 중복이 아닐 때
			return "success";
		} else {
			return "fail";
		}
	} // mbrEmailCheck End

}

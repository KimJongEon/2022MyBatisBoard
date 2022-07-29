package com.jongeon.mybatisboard.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.jongeon.mybatisboard.service.LoginService;

public class MyLoginSuccessHandler implements AuthenticationSuccessHandler {
	private LoginService loginService;
	
	@Override
	public void onAuthenticationSuccess(
			HttpServletRequest request,
			HttpServletResponse response,
			Authentication authentication
			) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String mbrEmail = authentication.getName();
		System.out.println(mbrEmail);
	
		System.out.println("MyLoginSuccessHandler 여기 오나요 @@@@@@@@@@@@@@@@@@@@@@@@@@@");
		response.sendRedirect("/");
		
	}

}

package com.jongeon.mybatisboard.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


public class MyLoginFailerHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException accessException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//out.print 사용을 위해 선언
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//오류확인
//		accessException.printStackTrace();

		if (accessException instanceof AuthenticationServiceException) {
//			request.setAttribute("error", "존재하지 않는 사용자입니다.");
			out.print("<script>alert('존재하지 않는 사용자입니다.');");
			out.print("location.href='/loginPage' ");
			out.print("</script>");
			
		} else if(accessException instanceof BadCredentialsException) {
			System.out.println("비밀번호 틀림");
//			request.setAttribute("error", "비밀번호가 틀립니다.");
			out.print("<script>alert('존재하지 않는 아이디거나 비밀번호가 일치하지 않습니다.');");
			out.print("location.href='/loginPage' ");
			out.print("</script>");
			
		} else if(accessException instanceof LockedException) {
//			request.setAttribute("error", "잠긴 계정입니다..");
			out.print("<script>");
			out.print("location.href='/loginPage' ");
			out.print("</script>");
			
		} else if(accessException instanceof DisabledException) {
//			request.setAttribute("error", "비활성화된 계정입니다..");
			out.print("<script>");
			out.print("location.href='/loginPage' ");
			out.print("</script>");
		} else if(accessException instanceof AccountExpiredException) {
//			request.setAttribute("error", "만료된 계정입니다..");
			out.print("<script>");
			out.print("location.href='/loginPage' ");
			out.print("</script>");
		} else if(accessException instanceof CredentialsExpiredException) {
//			request.setAttribute("error", "비밀번호가 만료되었습니다.");
			out.print("<script>");
			out.print("location.href='/loginPage' ");
			out.print("</script>");
		}
	} // onAuthenticationFailure End
} // AuthenticationFailureHandler End

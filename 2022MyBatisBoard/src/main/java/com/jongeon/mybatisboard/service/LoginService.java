package com.jongeon.mybatisboard.service;

import com.jongeon.mybatisboard.domain.MemberVO;

public interface LoginService {
	// mbrEmail로 해당 유저의 정보를 가져오는 메소드
	// LoginServiceImplement, MyLoginSuccessHandler 에서 사용
	public MemberVO findUserUsingEmail(String mbrEmail);

}

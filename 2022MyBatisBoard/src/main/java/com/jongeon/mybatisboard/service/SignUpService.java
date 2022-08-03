package com.jongeon.mybatisboard.service;

import com.jongeon.mybatisboard.domain.MemberVO;


public interface SignUpService {
	//회원가입
	public Long signUp(MemberVO memberVO);

	// mbrEmail 중복 체크
	public Long mbrEmailCheck(String mbrEmail);
}

package com.jongeon.mybatisboard.service;

import com.jongeon.mybatisboard.domain.MemberVO;

public interface LoginService {
	// 로그인시 해당 유저 찾는 메소드
	public MemberVO findUserForLogin(String mbrEmail);
}

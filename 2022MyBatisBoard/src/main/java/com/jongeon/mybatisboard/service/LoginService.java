package com.jongeon.mybatisboard.service;

import com.jongeon.mybatisboard.domain.MemberVO;

public interface LoginService {
	// mbrEmail로 해당 유저의 정보를 가져오는 메소드
	public MemberVO findUserForUsingEmail(String mbrEmail);
}

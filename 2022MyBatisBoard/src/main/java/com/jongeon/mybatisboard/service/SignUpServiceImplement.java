package com.jongeon.mybatisboard.service;

import org.springframework.stereotype.Service;

import com.jongeon.mybatisboard.domain.MemberVO;
import com.jongeon.mybatisboard.mapper.SignUpMapper;

@Service
public class SignUpServiceImplement implements SignUpService {
	private SignUpMapper signUpMapper;
	
	@Override
	public Long signUp(MemberVO memberVO) {
		// TODO Auto-generated method stub

		System.out.println("서비스확인@@@@@@@@");
		System.out.println(memberVO.signUp().getMbrEmail());
		System.out.println(memberVO.signUp().getMbrPassword());
		System.out.println(memberVO.signUp().getMbrNickName());
		
		
//		return signUpMapper.signUp(memberVO.signUp());
		return null;
	}
	
}

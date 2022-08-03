package com.jongeon.mybatisboard.service;

import org.springframework.stereotype.Service;

import com.jongeon.mybatisboard.domain.MemberVO;
import com.jongeon.mybatisboard.mapper.SignUpMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor // 생성자 생성 안하면 signUpMapper.signUp(memberVO.signUp()); 에서 null값 나옴 // 자동으로 모든 매개변수를 받는 생성자 생성
public class SignUpServiceImplement implements SignUpService {
	private SignUpMapper signUpMapper;
	
	//회원가입
	@Override
	public Long signUp(MemberVO memberVO) {
		// TODO Auto-generated method stub
//		try {
//			signUpMapper.signUp(memberVO.signUp());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		return signUpMapper.signUp(memberVO.signUp());
	}

	// mbrEmail 중복 체크
	@Override
	public Long mbrEmailCheck(String mbrEmail) {
		// TODO Auto-generated method stub
		
		return signUpMapper.mbrEmailCheck(mbrEmail);
	}
	
	// mbrNickName 중복 체크
	@Override
	public Long mbrNickNameCheck(String mbrNickName) {
		// TODO Auto-generated method stub
		return signUpMapper.mbrNickNameCheck(mbrNickName);
	}
	
}

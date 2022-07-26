package com.jongeon.mybatisboard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jongeon.mybatisboard.domain.MemberVO;

@Mapper
public interface SignUpMapper {
	// Service에서 아래 메소드를 호출하여 사용
	
	// 회원가입 메소드
	public Long signUp(MemberVO memberVO);

}

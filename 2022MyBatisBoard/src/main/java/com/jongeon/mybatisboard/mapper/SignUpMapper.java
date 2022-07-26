package com.jongeon.mybatisboard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jongeon.mybatisboard.domain.MemberVO;

@Mapper
public interface SignUpMapper {
	
	// 회원가입 메소드
	public Long signUp(MemberVO signUp);

}

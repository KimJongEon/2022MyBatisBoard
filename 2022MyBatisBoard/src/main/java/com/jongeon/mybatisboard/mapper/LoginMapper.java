package com.jongeon.mybatisboard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jongeon.mybatisboard.domain.MemberVO;

@Mapper
public interface LoginMapper {
	// 로그인시 해당 유저 찾는 메소드
	public MemberVO findUserForLogin(String mbrEmail);

}

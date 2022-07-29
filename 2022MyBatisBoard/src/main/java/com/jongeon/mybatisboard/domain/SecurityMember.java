package com.jongeon.mybatisboard.domain;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class SecurityMember extends User{
	private MemberVO memberVO;
	
	public SecurityMember(MemberVO memberVO) {
		// User(Details)로 return할때 id, password, 권한을 return해야 함
		super(memberVO.getMbrEmail(), memberVO.getMbrPassword(), List.of(new SimpleGrantedAuthority(memberVO.getMbrRole())) );
		this.memberVO = memberVO;
	}
	

	
	
}

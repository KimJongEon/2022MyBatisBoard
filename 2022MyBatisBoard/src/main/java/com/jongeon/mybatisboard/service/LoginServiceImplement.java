package com.jongeon.mybatisboard.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.jongeon.mybatisboard.domain.MemberVO;
import com.jongeon.mybatisboard.domain.SecurityMember;
import com.jongeon.mybatisboard.mapper.LoginMapper;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class LoginServiceImplement implements UserDetailsService, LoginService {
	private LoginMapper loginMapper;
	
	//로그인시 해당 사용자 찾는 메소드
	@Override
	public MemberVO findUserUsingEmail(String mbrEmail) {
		// TODO Auto-generated method stub
		System.out.println("LoginServiceImplement : "+mbrEmail);
		return loginMapper.findUserUsingEmail(mbrEmail);
	}
	
	//로그인 시 제일 먼저 오는 메소드
	@Override
	public UserDetails loadUserByUsername(String mbrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//로그인 한 사용자 찾음
		MemberVO memberVO = findUserUsingEmail(mbrEmail);
		
		SecurityMember securityMember = new SecurityMember(memberVO);
		
		// 로그인 시 SecurityMember에 memberVO 저장 
		return securityMember;
		
//		세션에서 해당 유저 정보를 안가져올 때 쓰던 코드		
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority(memberVO.getMbrRole()));
		// User(Details)로 return할때 id, password, 권한을 return해야 함
//		return new User(memberVO.getMbrEmail(), memberVO.getMbrPassword(), authorities);
	}
	
}

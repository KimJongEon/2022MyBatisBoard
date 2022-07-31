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
		
		// User를 extends한 로그인한 사용자에 대한 memberVO를 매개변수로 가지는 SecurityMember 생성
		// 그리고 SecurityMember에 memberVO 저장
		// securityMember.memberVO.getXXXXX 꺼내어 사용
		// session 대체 하기 위해 사용
		SecurityMember securityMember = new SecurityMember(memberVO);
		
		return securityMember;
		
//		세션에서 해당 유저 정보를 안가져올 때 쓰던 코드		
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority(memberVO.getMbrRole()));
		// User(Details)로 return할때 id, password, 권한을 return해야 함
//		return new User(memberVO.getMbrEmail(), memberVO.getMbrPassword(), authorities);
	}
	
}

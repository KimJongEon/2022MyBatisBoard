package com.jongeon.mybatisboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jongeon.mybatisboard.domain.MemberVO;
import com.jongeon.mybatisboard.mapper.LoginMapper;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class LoginServiceImplement implements UserDetailsService, LoginService {
	private LoginMapper loginMapper;
	
	@Override
	public MemberVO findUserForLogin(String mbrEmail) {
		// TODO Auto-generated method stub
		
		System.out.println("여긴??????????????????");
		return loginMapper.findUserForLogin(mbrEmail);
	}

	@Override
	public UserDetails loadUserByUsername(String mbrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		MemberVO memberVO = findUserForLogin(mbrEmail);
		
		System.out.println(memberVO);
		System.out.println(memberVO.getMbrEmail());
		System.out.println(memberVO.getMbrNickName());
		System.out.println(memberVO.getMbrPassword());
		
		System.out.println(mbrEmail);
		System.out.println("여기 오니***************");
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(memberVO.getMbrRole()));
			
		return new User(memberVO.getMbrEmail(), memberVO.getMbrPassword(), authorities);
	}

}

package com.jongeon.mybatisboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {

	//현재 Spring Boot 2.6.7 기준 Spring Security 5.6.3 을 사용하고 있지만 추후 5.7.X 부터
	//WebSecurityConfigurerAdapter 가 Deprecate 될 예정입니다.
	//Bean 사용
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		System.out.println("확인@@@@@@@@@@@@@@@@@@");
//		return(web) -> web.ignoring().antMatchers("/**");
		
		return(web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
	}
	
	
	@Bean
	public SecurityFilterChain sercurityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf().disable()
				.build();
		
	} //SecurityFilterChain End
}

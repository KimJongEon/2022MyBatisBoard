package com.jongeon.mybatisboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.jongeon.mybatisboard.handler.MyLoginFailerHandler;
import com.jongeon.mybatisboard.handler.MyLoginSuccessHandler;
import com.jongeon.mybatisboard.service.LoginServiceImplement;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig{
	private LoginServiceImplement loginService;
	
	//현재 Spring Boot 2.6.7 기준 Spring Security 5.6.3 을 사용하고 있지만 추후 5.7.X 부터
	//WebSecurityConfigurerAdapter 가 Deprecate 될 예정입니다.
	//Bean 사용
	
	
	// Service에서 비밀번호를 암호화 할 수 있도록 Bean으로 등록
	// PasswordEncoder 선언 안하면 DB에 암호와 되어 있는 password 인식 못해서 로그인 못함
	@Bean 
	public PasswordEncoder passwordEncoder () {
		System.out.println("SecurityConfig - PasswordEncoder 확인 @@@@@");
		// *BCryptPasswordEncoder 
		// 스프링 시큐리티(Spring Seurity) 프레임워크에서 제공하는 클래스 중 하나로 비밀번호를 암호화하는 데 사용할 수 있는 메서드를 가진 클래스
		return new BCryptPasswordEncoder();
	} // PasswordEncoder End
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		System.out.println("확인@@@@@@@@@@@@@@@@@@");
//		return(web) -> web.ignoring().antMatchers("/**");
		
		return(web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
	}
	
	
	@Bean
	public SecurityFilterChain sercurityFilterChain(HttpSecurity http) throws Exception {
		http
		// disable() 안하면 csrf 토큰이 없어 get, post 로 통신 불가능
		// csrf 토큰 비활성화(테스트시 해놓는게 편함), Security는 csrf토큰이 있어야 접근가능
//			.csrf().disable() 
			
			.authorizeRequests() // ########## (경로) 권한 설정 ##########
//			.antMatchers("/admin/**").hasRole("ADMIN") // admin 으로 시작하는 경로는 ADMIN 롤을 가진 사용자만 접근 가능
			.antMatchers("/**").permitAll() // 모든 경로에 대해 권한 없이 접근 가능
//			.antMatchers("/postDetailPage/**").hasRole("USER")
//			.antMatchers("/postDetailPage/**").hasAuthority("USER")
			
			
			.and().formLogin() // ########## 로그인 설정 ##########
			.usernameParameter("mbrEmail") // 아이디 파라미터 [기본 값 "username"] -> "mbrEmail" 변경
			.passwordParameter("mbrPassword") // 비밀번호 파라미터 [기본 값 "password"] -> "mbrPassword" 변경
			.loginPage("/") // 로그인 URL 
			.loginProcessingUrl("/securityLogin") //Spring Security 가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인해줌(서비스의 loadUserByUsername로 알아서)
//			.defaultSuccessUrl("/", true) // 로그인 성공시 이동하게 되는 URL *컨트롤러에 해당 URL 맵핑 되어 있어야함 '/'가 첫 페이지인 postListPage로 맵핑되어있음
//			.failureUrl("/loginPage") // 로그인 실패시 이동하게 되는 URL			
			.successHandler(new MyLoginSuccessHandler())//로그인 성공시 Handler 이용하여 처리
			.failureHandler(new MyLoginFailerHandler())//로그인 실패시 handler 이용하여 처리
//			.permitAll() // 로그인시 이동하게 되는 URL 은 권한 없이 접근 가능
			
			.and().logout() // ##### 로그아웃 설정 #####
			.logoutRequestMatcher(new AntPathRequestMatcher("/securityLogOut")) // 로그아웃 URL 설정 , Controller로 가지 않고 가로 챔
			.logoutSuccessUrl("/") // 로그아웃 성공시 이동하게 되는 URL *마찬가지로 컨트롤러에 해당 URL 맵핑 되어 있어야함
			.invalidateHttpSession(true) // 로그아웃시 HTTP 세션을 초기화
			
			.and()
			.userDetailsService(loginService)
			// 중복 로그인 체크
			.sessionManagement()
			.maximumSessions(1) // 세션 최대 허용 수
			.maxSessionsPreventsLogin(false); // false : 중복 로그인하면 이전 로그인이 풀림
		
		return http.build();
	} //SecurityFilterChain End
}

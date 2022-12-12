# 게시판 프로젝트 (2022MyBatisBoard)

## ►프로젝트 소개
- 웹 프로그래밍의 기본인 CRUD(Creat, Read, Update, Delete)와 구조를 파악하기 위해 게시판 프로젝트를 시작했습니다.
- 회원가입 후 글, 댓글을 작성 할 수 있는 기본적인 게시판 입니다.

## ☑︎구현 기능
>로그인 (Spring Security)
- 로그인 시 LoginSeccessHandler를 이용, BCrypt로 암호화 된 사용자 비밀번호 검증
- 로그인 실패 시 LoginFailerHandler를 이용, 존재하지 않는 사용자 및 비밀번호 불일치시 Alert 창 안내
- 중복 로그인 시 먼저 로그인 한 세션 만료

>회원가입
- 회원가입 시 이메일, 비밀번호, 닉네임 유효성 검사
- BCrypt를 이용, 비밀번호 암호화

>게시판
- 글 쓰기
- 글 수정 (해당 글의 본인만 수정, 삭제 가능)
- 페이징
- 조회수 (글 조회 할 때 마다 조회수 1증가)

>댓글 (해당 댓글의 본인만 수정, 삭제 가능) 
- 작성
- 수정
- 삭제

*로그인 한 사용자만 글, 댓글 작성 가능

<br>

> 로그인을 하지 않은 경우 아래 페이지 사용 가능
- 로그인 페이지
- 글 목록 페이지
- 글 상세 페이지
- 회원가입 페이지


## ☞실행 화면 (하위 카테고리 클릭 시 펼쳐 짐)
<details>
  <summary>회원가입</summary>

  <br>
  
  <!-- summary 아래 한칸 공백 두어야함 -->
  >아이디 입력 경고 창
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/185039975-1f609fdd-6d83-4ec8-be11-bab4013fc944.png">
  
  ---  
  
  >아이디가 이메일 형식인지 유효성 검사
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/185040056-5c2022bd-4304-4cb0-8d83-916bf2f6a67f.png">
  
  ---
  
  >아이디(이메일) 중복 체크
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/185040244-9047d8b4-cb43-4e60-aef7-6d049c7a32fe.png">
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/185040303-0d99871e-e223-4889-815a-bc955292c0ea.png">
  
  ---
  
  >비밀번호 유효성 검사
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/185041153-7c820740-fc9e-4845-bfb2-74d2d70550a4.png">
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/185041252-b6d186a5-a2e8-4207-9398-2c9c6ac7067c.png">
  
  ---
  
  >닉네임 유효성 검사 (*모든 유효성 검사 통과 시 '완료' 버튼 활성화)
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/185041473-0ef9baf0-5fff-4237-b3a4-d2fcbe056ee6.png">
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/185041676-54e4ed00-7e63-4347-9786-fad4671fc40d.png">
  
  ---
  
  >DB엔 암호화 된 비밀번호로 저장
   <img width="364" alt="image" src="https://user-images.githubusercontent.com/45247057/185523100-53d43a30-2750-4bff-a9c2-a9248aeebb9e.png">

  ---
  
</details>

<details>
  <summary>로그인 (Spring Security)</summary>
  
  <br>
  
  <!-- summary 아래 한칸 공백 두어야함 -->
  >로그인 시 이메일 유효성 검사
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186069142-53e6a5c0-f129-47f0-b7e4-b5ca8f8d14e7.png">
  
  ---
  
  >비밀번호 불일치 시 Alert 창
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186069522-a75f3938-38ba-4ae7-967e-f87686e7a75d.png">

  ---
  
  >로그인
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186072544-42ddbd20-f811-43a8-aba6-14befe1e5a0c.png">

  - 이메일 형식의 아이디 입력 후 로그인 버튼 클릭
  
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186072672-8c212c7d-1736-4e1d-8240-aba834a4a040.png">

  - 로그인 시 홈 화면으로 이동
  
  ---
  
  >중복 로그인 시 먼저 로그인 한 세션 만료
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/185856590-fb2a4b16-ae2f-41a9-87ae-61ace57e41af.png">
  
  ---
</details>

<details>
  <summary>글 상세 화면, 쓰기, 수정, 삭제</summary>
  
  <br>
  
  <!-- summary 아래 한칸 공백 두어야함 -->
  >글 쓰기
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186072813-89cc0093-0472-43b3-af16-c95107e28944.png">
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186070102-0e1fde00-bb49-43c1-94df-000d96d60fd3.png">

  - 제목과 내용 입력 후 등록
  - 새 글 쓰기 클릭 시 세션이 없을 경우 로그인 페이지로 이동
  
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186086320-0f6378eb-6650-4192-94d8-b92fbb3950cc.png">
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186086402-ae247af2-59f7-49ca-b2a9-311b58575338.png">
  
  - 글 제목 또는 내용이 공백, 스페이스바, 탭으로 입력 된 경우 alert 창 안내
  
  ---
  
  >글 상세 화면
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186071174-327ac890-382f-41a9-9e61-39c1289c2513.png">
  
  - 작성자 닉네임, 글 작성 일시, 댓글 목록 표시
  - 해당 글 작성자만 글 수정, 삭제 가능 (Spring Security, session 이용)
  
  ---
  
  >글 수정 화면
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186071598-c76fad2e-c50e-4bf8-833e-70c4563f2b14.png">
  
  - 글 제목 혹은 내용 수정 후 수정 버튼 클릭
  
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186072093-187d21f4-a136-4239-90d6-9684ebe0ae7f.png">

  - 수정 완료 후 수정한 글의 상세 페이지로 이동
  
  ---
</details>

<details>
  <summary>댓글</summary>
  
  <br>
  
  <!-- summary 아래 한칸 공백 두어야함 -->
  >댓글 등록
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186083128-47f22b8a-42b7-4849-b45f-29ef15c638be.png">

  - 댓글 내용 입력 후 등록
  
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186083192-15600d0f-edf4-41a9-9a45-c19d11d30d3d.png">

  - 댓글 내용이 공백, 스페이스바, 탭 일 경우 alert창 안내
  
  ---
  
  >댓글 수정
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186074387-30148868-5f46-4113-a3b1-77eb09cfe712.png">
  
  - 수정 버튼 html remove
  
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186074575-a08fb69b-d405-4bd3-b867-17574d194959.png">

  - 댓글 수정 완료
  
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186074845-d7b72cfe-f1f4-422a-ba17-6c010d2e2564.png">

  - 댓글 수정 취소시 html만 조작하여 원래 화면으로 복귀 (DB접근 X)
  
  ---
  
  >댓글 삭제
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186075145-c0698cdd-2bbd-484a-8ba1-4455fa0a4c39.png">

  - 댓글 삭제 시 confirm 창으로 확인
  
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186075360-c22134d4-5d2b-4fd3-af31-c1b53b5300ca.png">
  
  - 삭제 완료
  
  ---
  
  >댓글 없을 때 화면
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186073464-dde526d9-84ce-41f8-9ddb-608174d92f52.png">
  
  ---
  
  >댓글 있을 때
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186073858-9183907e-018b-4901-96b3-6b0094cde834.png">

  - 본인 만 삭제, 수정 가능
  
  ---
 
</details>

<details>
  <summary>페이징</summary>
  
  <br>
  
  <!-- summary 아래 한칸 공백 두어야함 -->
  - 페이징 - 한 페이지 당 보여질 글 개수 5개로 세팅
  
  >1번 화면
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186087112-2ce9e512-3391-49c2-984d-78ba120416fa.png">
  
  ---
  
  >2번 화면
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186087199-b7916e06-a409-4bfe-b4a7-352191aa6cda.png">

  ---
  
  >3번 화면
  <img width="1440" alt="image" src="https://user-images.githubusercontent.com/45247057/186087286-cc088cb9-c496-4fed-955a-50b056fb7312.png">

  ---
</details>





## ▷개발 환경
>운영체제
- Mac 12.2.1

>IDE
- STS4 (Spinrg Tool Suite 4) 4.14.1

>기술
- JAVA 11
- DataBase - MariaDB 10.6.7 (AWS RDS)
- Spring 5.3.21
- SpringBoot 2.7.1
- Spinrg Security 5.7.2
- 
>DataBase
- Dbeaver (관리 툴)
- ERD
![image](https://user-images.githubusercontent.com/45247057/186076297-f82fb01b-9929-40c5-861f-39eaeda7583f.png)





<br><br><br>

# ✎마치며

> 개선해아할 점
- Controller가 지저분 합니다.
  - controller는 view와 VO의 요청이 있으면 전달 하는 역할만 해주는게 깔끔한데 세션처리를 위한 핑계로 Controller가 복잡해졌습니다.
  - 그래서 비즈니스 로직은 최대한 VO에 혹은 service단에 작성 할 수 있도록 더 노력이 필요하다고 느낍니다.


> 후기
- Spring Boot + gradle은 따로 Tomcat 설치도 필요없고 XML파일 설정할 필요도 거의 없어 편리했습니다.
- 다음 프로젝트에선 controller에서 model 객체를 이용해 return 하는 대신 Rest API 이용하는 프로젝트를 만들어 볼 예정입니다. (프론트는 React)



<br/><br/><br/><br/><br/><br/><br/><br/><br/>

절취선

---

<br/><br/><br/><br/><br/><br/><br/><br/><br/>

## 패키지 구조
>요약
- 이미지
  - <img width="276" alt="image" src="https://user-images.githubusercontent.com/45247057/187376419-99507e0e-1d55-44ba-8b66-c92f16d1d341.png">
    
    - src/main/java
      - com.jongeon.mybatisboard
        - config, controller, domain, handler, mapper, service
    - src/main/resources
      - templates : thymeleaf를 사용한 .html 파일 관리
      - mybatis-mapper : mapper.xml 파일 관리
      - static : css, js, images 등 정적 파일 관리
      - application.yml 파일은 DB주소, 비밀번호 등 노출되면 안되는 정보가 있기 때문에 github ignore file로 등록하여 관리
      
---


# 마치며
>후기
- Spring Boot + gradle은 따로 Tomcat 설치도 필요없고 XML파일 설정할 필요도 거의 없어 편리했습니다.
- 혼자서 MVC 패턴을 익히는데 게시판 만들기는 좋은 교보재라고 생각합니다. (재미는 없습니다..)
- 게시판도 이것저것 기능 추가하려고 하니 생각보다 프로젝트가 커지네요..
- Spring Security를 사용한 이유
  - interceptor를 사용해서 로그인 구현을 해본적이 있습니다.
  - 개인 프로젝트엔 사용하지 않았던 기술들을 사용해보는게 좋겠다고 생각해서 Spring Security를 사용했습니다.
- Spring, Spring Security 버전
  - <img width="222" alt="image" src="https://user-images.githubusercontent.com/45247057/187578582-0dd8b361-df4b-45db-8a83-5630c69d7430.png">
    
    - 프로젝트 리뷰하려고 이것저것 찾아보다가 발견했는데 Spring 버전보다 Spring Security 버전이 낮아야 된다고 하던데 security 버전이 더 높네요..
    - 일단 사용해보자라는 마인드로 프로젝트를 진행하다보니 버전 확인도 안하고 사용했습니다.
    - 오류없이 잘 돌아가서 다행이긴한데 다시 버전 낮추면 문제 생길 것 같아 그대로 두겠습니다.
    - 다음엔 버전 확인 잘 하고 해야겠습니다.


- Spring Security 비밀번호는 Bcrypt 암호화 필수, 로그인시 사용자 권한(ROLE_XXX)가 필요, 

>아쉬운점
- Controller가 지저분 합니다.
  - controller는 view와 VO의 요청이 있으면 전달 하는 역할만 해주는게 깔끔한데 세션처리를 위한 핑계?로 Controller가 복잡해졌습니다.
  - 그래서 비즈니스 로직은 최대한 VO에 혹은 service단에 작성 할 수 있도록 더 노력이 필요하다고 느낍니다..
- 주석
  - 주석을 최대한 작성을 하긴 했는데 중구난방으로 작성한 느낌입니다..
- Spring Security
  - '일단 써보자'라는 생각으로 무작정 따라하며 프로젝트에 적용을 해봤는데 좀 더 공부가 필요해 보입니다.
  - BCrypt로 암호된 비밀번호가 어떻게, 어디에서 비교하여 인증되는지와 같은..  
*로그인시 BCrypt로 암호화된 비밀번호와 부여된 ROLE_XXXX를 비교하여 인증하고 부여된 ROLE이 없으면 로그인 인증 불가능한 것 까지는 알아냈습니다.
  


>다음 프로젝트엔..
- @AllArgsConstructor 대신 @RequiredArgsConstructor을 사용, 필드에 final 사용
- controller에서 model 객체를 이용해 return 하는 대신 Rest API 이용(@RestController)
- 프론트는 React



<br><br><br>

---
# 정리
>의존성 주입 (Dependency Injection)
- 의존성 주입이란
  - 스프링이 다른 프레임워크와 차별화되어 제공하는 의존 관계 주입 기능
  - 객체를 (개발자가)직접 생성하는 게 아니라 외부(Spring IoC Container)에서 생성한 후 주입 시켜주는 방식

>의존성 주입 방법
- 생성자 주입(Constructor Injection) : 권장
  - 주로 Lombok 라이브러리의 @AllArgsConstructor, @RequiredArgsConstructor 어노테이션 이용
  - 권장 및 사용이유?
    - 필드 주입시 순환참조 발생 가능
    - 순환참조 문제란 A 클래스가 B 클래스의 Bean 을 주입받고, B 클래스가 A 클래스의 Bean 을 주입받는 상황처럼 서로 순환되어 참조할 경우 발생하는 문제를 의미
    - 결국 Stack Over Flow 발생
- 필드 주입(Field Injection)
  - @Autowired 어노테이션 이용
- 수정자 주입(Setter Injection)

>Spring IoC(Inversion of Controll) Container, Bean
- Inversion of Controll : 제어의 역전, 제어 반전
- Bean은 Spring IoC Container가 관리하는 자바 객체 (*범위 : 자바 객체 > Bean)

- 기존에는 다음과 순서로 객체가 만들어지고 실행되었다.
  - 객체 생성
  - 의존성 객체 생성
    - 개발자가 클래스 내부에 직접 생성
  - 의존성 객체 메소드 호출

- 하지만, 스프링에서는 다음과 같은 순서로 객체가 만들어지고 실행된다.
  - 객체 생성
  - 의존성 객체 주입
    - 개발자 스스로 만드는것이 아니라 제어권을 스프링에게 위임하여 스프링이 만들어놓은 객체를 주입한다.
  - 의존성 객체 메소드 호출

- Spring IoC Container가 개발자 대신 Bean의 생성 및 관리를 대신해 준다.
- Bean은 개발자가 IoC에 등록한 객체들이라고 생각하면 된다. 그래서 등록한 Bean을 IoC Container가 관리.
- 그렇게 되면 개발자는 비즈니스 로직에 집중 할 수 있다.

>결론은..
- 생성자를 매번 수동으로 만들면 번거로우니
- Lombok 라이브러리를 사용
- @AllArgsConstructor, @RequiredArgsConstructor 어노테이션으로 생성자를 만들자..
  - @RequiredArgsConstructor, final 이용 권장

---


>빌더 패턴 (Builder Pattern)
- 사용이유?
  - 필요한 데이터만 설정 할 수 있다.
  - 인스턴스를 생성할 때 인자를 선택적으로 가독성 좋게 넘길 수 있다.
  - 인자의 순서에 상관이 없어진다.
  - 변경 가능성을 최소화 할 수 있다. (변수를 final로 선언)
- 프로젝트에서 빌더 패턴 적용
  - PostVO
    - <img width="918" alt="image" src="https://user-images.githubusercontent.com/45247057/187353737-ecd72d5c-3155-40eb-a082-e27b37772e67.png">
  - PostController
    - <img width="1158" alt="image" src="https://user-images.githubusercontent.com/45247057/187353644-a886ab5e-0a48-46bb-9c11-c8b8ac487eb5.png">
    
    - PosvVO의 첫 번째 변수는 postNumber이지만 PostController에서 빌더 패턴으로 객체 생성시 mbrIdx가 첫번 째로 온 것을 확인 할 수 있다. 즉 인자의 순서가 상관 없다
    - PostVo엔 postNumber ~ replyCount까지 변수가 있지만 빌더 패턴으로 객체를 생성 했을 때 mbrIdx, postTitle, postContent만 가지고 생성했다. 즉 필요한 데이터만 설정하여 객체를 생성했다.

---

>Spring Security
>>Spring Security Architecture는 Authentication, Authorization 즉 인증과 권한(부여)를 제어한다
- ![image](https://user-images.githubusercontent.com/45247057/187590144-3e81cdde-2650-4c93-9a9b-b0fd0a6e4219.png)

   - 출처 : https://www.inflearn.com/course/%EC%8A%A4%ED%94%84-spring-1#curriculum


- ![image](https://user-images.githubusercontent.com/45247057/187593967-77478afb-0b4f-4f20-958b-7c37b8caf2f3.png)
   
   - 출처 : https://angryfullstack.tistory.com/entry/%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%9D%B8%EC%A6%9D-%EC%9D%B8%EA%B0%80-%EC%B2%98%EB%A6%AC-%EB%B3%B4%EC%95%88-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0-Spring-Secruit-1%ED%8E%B8
   - 그림 처럼 Spring Security는 로그인 과정을 위해 대신 많은 것들을 처리 해준다.

1. 사용자가 Form으로 로그인 정보를 입력하고 Http프로토콜로 인증요청을 Server로 보냄
2. AuthenticationFilter (UsernamePasswordAuthenticationFilter)가 HttpServletRequest에서 사용자가 보낸 아이디와 패스워드를 인터셉트 함
아이디와 패스워드 유효성 검사 이후 HttpServletRequest에서 사용자아이디, 패스워드 인증을 담당할 AuthenticationManager 인터페이스(Providermanager)에게 인증용 객체(UsernamePasswordAuthenticationToken)를 위함
3. AuthenticationFilter 에 인증용 객체(UsernamePasswordAuthenticationToken) 전달
4. 인증할 AuthenticationProvider에게 Authentication 객체 (UsernamePasswordAuthenticationToken) 다시전달 받음
5. DB에서 사용자 인증정보를 가져올 UserDetailService에 유니크한 식별자(email, hp, name, id)를 전달 후
사용자 정보(사용자아이디, 암호화된 패스워드, 권한)를 UserDetails(인증용 객체와 도메인 객체를 분리하지 않기 위해서 실제 사용되는 도메인 객체 UserDetails 상속하기도 함) 객체로 전달 받음
6. AuthenticationProvider는 UserDetails 객체를 전달 받은 이후 실제 사용자의 입력정보와 UserDetails 객체를 가지고 인증 시도

- 7 ~ 9 : 요청한 내용들을 기반으로 Response전달함.

10. 인증이 완료되면 사용자 정보를 가진 Authentication 객체를 SecurityContextHolder에 담은 이후 AuthenticationSuccessHandle를 실행

(실패시 AuthenticationFailureHandler 실행)  

---

>비밀번호 비교는 어디서할까?
- 회원가입시 MemberVO 빌더패턴으로 아이디, 비밀번호(BCrypt로 암호화) 등을 DB에 저장한다.
  - <img width="575" alt="image" src="https://user-images.githubusercontent.com/45247057/187611532-8dcb5885-a622-431f-a4ca-411f1de9ba3c.png">

- 그 후 해당 아이디로 로그인 요청시 loadUserByUsername 까지 오는건 알겠는데 도대체 비빌번호 비교는 어디서 하는걸까?
  - <details>
      <summary>해당 코드에 findUserUsingEmail, SecurityMember 존재 이유</summary>
  
    <!-- summary 아래 한칸 공백 두어야함 -->
     - Spring Security는 현재 사용자 정보를 가져올 수 있다. (하지만 가져 올 수 있는 정보가 한정적)
     - 로그인시 해당 사용자 찾는 findUserUsingEmail 메소드 생성
     - User를 extends한 SecurityMember 클래스를 만들고 memberVO를 매개변수로 가지는 SecurityMember 메소드를 만들었다.
      - 로그인한 사용자의 mbrNickName을 찾을 때 사용
  
    </details>  

  
~~~java
@AllArgsConstructor
@Service
public class LoginServiceImplement implements UserDetailsService, LoginService {
	private LoginMapper loginMapper;
	
	//로그인시 해당 사용자 찾는 메소드
	@Override
	public MemberVO findUserUsingEmail(String mbrEmail) {
		// TODO Auto-generated method stub
//		System.out.println("LoginServiceImplement : "+mbrEmail);
		return loginMapper.findUserUsingEmail(mbrEmail);
	}
	
	//로그인 시 제일 먼저 오는 메소드
	@Override
	public UserDetails loadUserByUsername(String mbrEmail) throws UsernameNotFoundException{
		// TODO Auto-generated method stub
	
		//로그인 한 사용자 찾음
		MemberVO memberVO = findUserUsingEmail(mbrEmail);
		if(memberVO != null) {

			// User를 extends한 SecurityMember
			// 로그인한 사용자에 대한 memberVO를 매개변수로 가지는 SecurityMember 생성
			// securityMember.memberVO.getXXXXX 꺼내어 사용
			// session 대체 하기 위해 사용
			SecurityMember securityMember = new SecurityMember(memberVO);
			
			return securityMember;
		}else {
			throw new UsernameNotFoundException(mbrEmail);
		}
	}
	
}


~~~

- DaoAuthenticationProvider라는 클래스에서
  - additionalAuthenticationChecks 메소드 안에
  - this.passwordEncoder.matches(presentedPassword, userDetails.getPassword() 를 확인할 수 있다.
  - 이 부분에서 실질적으로 DB의 데이터와 입력한 비밀번호를 비교하는 곳 
~~~java
  @Override
	@SuppressWarnings("deprecation")
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		if (authentication.getCredentials() == null) {
			this.logger.debug("Failed to authenticate since no credentials provided");
			throw new BadCredentialsException(this.messages
					.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
		}
		String presentedPassword = authentication.getCredentials().toString();
		if (!this.passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
			this.logger.debug("Failed to authenticate since password does not match stored value");
			throw new BadCredentialsException(this.messages
					.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
		}
	} 
~~~

- PasswordEncoder 인터페이스에 가면 matches()를 확인 할 수 있다.
~~~java
public interface PasswordEncoder {
	String encode(CharSequence rawPassword);
  
  //additionalAuthenticationChecks에서 사용한 matches()
	boolean matches(CharSequence rawPassword, String encodedPassword);

	default boolean upgradeEncoding(String encodedPassword) {
		return false;
	}

}
~~~

- 생략된 부분이 많으니 [Spring Security 인증 과정](https://cjw-awdsd.tistory.com/45)을 읽어보면 전체적인 흐름을 확인할 수 있다.

---


>참고 사이트
- Spring IoC
  - https://dev-coco.tistory.com/80
- 스프링 : 생성자 주입을 사용해야 하는 이유, 필드인젝션이 좋지 않은 이유
  - https://yaboong.github.io/spring/2019/08/29/why-field-injection-is-bad/
- 생성자 주입은 왜 권장되며 순환참조란 뭘까?
  - https://velog.io/@walker/Spring-%EC%99%9C-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%A3%BC%EC%9E%85%EC%9D%B4-%EA%B6%8C%EC%9E%A5%EB%90%98%EB%A9%B0-%EC%88%9C%ED%99%98%EC%B0%B8%EC%A1%B0%EB%9E%80-%EB%AD%98%EA%B9%8C
- 의존성 주입 (Dependency Injection)
  - https://www.nextree.co.kr/p11247/
  - https://velog.io/@gillog/Spring-DIDependency-Injection
- 의존성 주입 3가지 방법
  - https://dev-coco.tistory.com/70
- 스프링 빈을 등록하는 두 가지 방법
  - https://dev-coco.tistory.com/69
- 빌더 패턴 사용 이유, 사용 경우
  - https://insight-bgh.tistory.com/339 
- Spring Security
  - Spring Security란 
    - https://velog.io/@sc_shin/Spring-Security%EB%9E%80
  - Spring Security Guide 공식문서
    - https://spring.io/guides/topicals/spring-security-architecture
  - Spring Security Architecture 내용정리
    - https://jasper-rabbit.github.io/posts/spring-security-architecture-review/
  - Spring Security 인증은? (비밀번호 검사 포함)
    - https://cjw-awdsd.tistory.com/45 
  - UserDetailsService에서 비밀번호는 어디에서 검사
    - https://velog.io/@nestour95/Spring-Security-UserDetailsService%EC%97%90%EC%84%9C-%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8%EB%8A%94-%EC%96%B4%EB%94%94%EC%97%90%EC%84%9C-%EA%B2%80%EC%82%AC%ED%95%98%EB%8A%94-%EA%B1%B8%EA%B9%8C
    - https://github.com/HomoEfficio/dev-tips/blob/master/Spring%20Security%EC%9D%98%20%EC%82%AC%EC%9A%A9%EC%9E%90%20%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8%20%EA%B2%80%EC%82%AC.md
- Spring 필터(Filter) vs 인터셉터(Interceptor) 차이 및 용도
  - https://mangkyu.tistory.com/173






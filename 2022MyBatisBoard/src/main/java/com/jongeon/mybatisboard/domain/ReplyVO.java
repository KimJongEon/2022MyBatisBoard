package com.jongeon.mybatisboard.domain;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor( access = AccessLevel.PROTECTED) //파라미터가 없는 기본 생성자 생성 // protected로 변경하면 new Member() 사용을 막을 수 있어 객체의 일관성을 더 유지할 수 있다.
@AllArgsConstructor // 자동으로 모든 매개변수를 받는 생성자를 생성
@Getter //값을 반환해주는 getter를 자동으로 만들어주는 lombok annotation
@Builder // 필드의 순서에 상관없이 객체 생성 가능, 원하는 필드만 가지고 객체 생성가능 //필드 : 클래스에 포함된 변수
public class ReplyVO {
	private Long replyNumber; // PK
	private String replyContent; //댓글 내용
	private LocalDateTime replyDate; //댓글 시간
	
	// FK
	private Long mbrIdx; // FK
	private Long postNumber; // FK
	
	private String mbrNickName; // 댓글 닉네임 표시
}

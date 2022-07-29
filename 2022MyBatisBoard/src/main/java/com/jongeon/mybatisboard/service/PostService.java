package com.jongeon.mybatisboard.service;

import java.util.List;

import com.jongeon.mybatisboard.domain.PostVO;
import com.jongeon.mybatisboard.domain.SecurityMember;

public interface PostService {
	
	// 글 목록 메소드
	public List<PostVO> postList();
	
	// 글 상세 페이지 메소드
	public PostVO postDetail(Long postNumber);
	
	// 글 작성 메소드
	public Long postRegister(PostVO postVO);

	// 제일 최신 글의 postNumber를 가져오는 메소드
	public PostVO findPostNumber();
}

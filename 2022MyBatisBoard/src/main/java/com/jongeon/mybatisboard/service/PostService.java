package com.jongeon.mybatisboard.service;

import java.util.List;

import com.jongeon.mybatisboard.domain.PostVO;

public interface PostService {
	
	// 글 목록 메소드
	public List<PostVO> postList();
	
	// 글 상세 페이지 메소드
	public PostVO postDetail(Long postNumber);
}

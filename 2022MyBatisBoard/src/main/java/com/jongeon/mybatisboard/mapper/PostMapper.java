package com.jongeon.mybatisboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jongeon.mybatisboard.domain.PostVO;

@Mapper
public interface PostMapper {
	
	// 글 목록 메소드
	public List<PostVO> postList();
	
	// 글 상세 페이지 메소드
	public PostVO postDetail(Long postNumber);

	// 글 작성 메소드
	public Long postRegister(PostVO postVO);
}

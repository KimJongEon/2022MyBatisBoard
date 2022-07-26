package com.jongeon.mybatisboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jongeon.mybatisboard.domain.PostVO;
import com.jongeon.mybatisboard.mapper.PostMapper;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor // 생성자 생성 안하면 signUpMapper.signUp(memberVO.signUp()); 에서 null값 나옴 // 자동으로 모든 매개변수를 받는 생성자 생성
public class PostServiceImplement implements PostService {
	private PostMapper postMapper;
	
	//글 목록
	@Override
	public List<PostVO> postList() {
		// TODO Auto-generated method stub
		return postMapper.postList();
	}
	
	//글 상세 페이지
	@Override
	public PostVO postDetail(Long postNumber) {
		// TODO Auto-generated method stub
		return postMapper.postDetail(postNumber);
	}

}

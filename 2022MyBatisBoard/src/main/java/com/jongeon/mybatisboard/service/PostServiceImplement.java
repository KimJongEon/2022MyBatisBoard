package com.jongeon.mybatisboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jongeon.mybatisboard.domain.PagingVO;
import com.jongeon.mybatisboard.domain.PostVO;
import com.jongeon.mybatisboard.mapper.PostMapper;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor // 생성자 생성 안하면 signUpMapper.signUp(memberVO.signUp()); 에서 null값 나옴 // 자동으로 모든 매개변수를 받는 생성자 생성
public class PostServiceImplement implements PostService {
	private PostMapper postMapper;
	
	//글 목록, 페이징 추가
	@Override
	public List<PostVO> postList(PagingVO pagingVO) {
		// TODO Auto-generated method stub
		return postMapper.postList(pagingVO);
		
	}
	
	//글 상세 페이지
	@Override
	public PostVO postDetail(Long postNumber) {
		// TODO Auto-generated method stub
		return postMapper.postDetail(postNumber);
	}
	
	// 글 작성 메소드
	@Override
	public Long postRegister(PostVO postVO) {
		// TODO Auto-generated method stub
		return postMapper.postRegister(postVO);
	}

	// 제일 최신 글의 postNumber를 가져오는 메소드
	@Override
	public PostVO findPostNumber() {
		// TODO Auto-generated method stub
		return postMapper.findPostNumber();
	}

	// 글 삭제 메소드
	@Override
	public Long postDel(Long postNumber) {
		// TODO Auto-generated method stub
		return postMapper.postDel(postNumber);
	}

	//글 수정 메소드
	@Override
	public Long postEdit(Long postNumber, String postTitle, String postContent) {
		// TODO Auto-generated method stub
		return postMapper.postEdit(postNumber, postTitle, postContent);
	}

	//	페이징을 위한 게시글 전체 개수 가져오기
	@Override
	public int postListCnt() {
		// TODO Auto-generated method stub
		return postMapper.postListCnt();
	}
	
	// 조회수 증가 메소드
	@Override
	public int updateReadCnt(Long postNumber) {
		// TODO Auto-generated method stub
		return postMapper.updateReadCnt(postNumber);
	}

}

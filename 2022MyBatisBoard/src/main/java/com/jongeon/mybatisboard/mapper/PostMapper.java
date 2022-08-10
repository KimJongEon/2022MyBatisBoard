package com.jongeon.mybatisboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jongeon.mybatisboard.domain.PagingVO;
import com.jongeon.mybatisboard.domain.PostVO;

@Mapper
public interface PostMapper {
	
	// 글 목록 메소드, 페이징 추가
	public List<PostVO> postList(PagingVO pagingVO);
	
	// 글 상세 페이지 메소드
	public PostVO postDetail(Long postNumber);

	// 글 작성 메소드
	public Long postRegister(PostVO postVO);

	// 제일 최신 글의 postNumber를 가져오는 메소드
	public PostVO findPostNumber();
	
	// 글 삭제 메소드
	public Long postDel(Long postNumber);

	// 글 수정 메소드 -  2개이상의 파라미터를 넘길 때는 @Param 어노테이션을 이용하여 파라미터를 지정해주어야 한다
	public Long postEdit(@Param("postNumber") Long postNumber, @Param("postTitle") String postTitle, @Param("postContent") String postContent);

	// 페이징을 위한 게시글 전체 개수 가져오기
	public int postListCnt();
	
	// 조회수 증가 메소드
	public int updateReadCnt(Long postNumber);
}

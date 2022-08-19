package com.jongeon.mybatisboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jongeon.mybatisboard.domain.ReplyVO;

@Mapper
public interface ReplyMapper {
	
	// 댓글 리스트를 가져오는 메소드
	public List<ReplyVO> replyList(Long postNumber);

	// 댓글 등록 메소드 - 2개이상의 파라미터를 넘길 때는 @Param 어노테이션을 이용하여 파라미터를 지정해주어야 한다
	public Long replyRegister(@Param("mbrIdx") Long mbrIdx, @Param("postNumber") Long postNumber, @Param("replyContent") String replyContent);

	// 댓글 삭제 메소드
	public Long replyDel(@Param("replyNumber") Long replyNumber);
}

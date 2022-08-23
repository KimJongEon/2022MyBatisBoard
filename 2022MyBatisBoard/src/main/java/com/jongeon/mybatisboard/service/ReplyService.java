package com.jongeon.mybatisboard.service;

import java.util.List;

import com.jongeon.mybatisboard.domain.ReplyVO;

public interface ReplyService {
	
	// 댓글 리스트를 가져오는 메소드
	public List<ReplyVO> replyList(Long postNumber);

	// 댓글 등록 메소드
	public Long replyRegister(Long mbrIdx, Long postNumber, String replyContent);

	// 댓글 삭제 메소드
	public Long replyDel(Long replyNumber);
	
	// 댓글 수정 메소드
	public Long replyEdit(Long replyNumber, String replyEditContent);
}

package com.jongeon.mybatisboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jongeon.mybatisboard.domain.ReplyVO;
import com.jongeon.mybatisboard.mapper.ReplyMapper;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ReplyServiceImplement implements ReplyService {
	private ReplyMapper mapper;
	
	// 댓글 리스트를 가져오는 메소드
	@Override
	public List<ReplyVO> replyList(Long postNumber) {
		// TODO Auto-generated method stub
		return mapper.replyList(postNumber);
	}
	
	// 댓글 등록 메소드
	@Override
	public Long replyRegister(Long mbrIdx, Long postNumber, String replyContent) {
		// TODO Auto-generated method stub
		return mapper.replyRegister(mbrIdx, postNumber, replyContent);
	}
	
	// 댓글 삭제 메소드
	@Override
	public Long replyDel(Long replyNumber) {
		// TODO Auto-generated method stub
		return mapper.replyDel(replyNumber);
	}
	
	
	// 댓글 수정 메소드
	@Override
	public Long replyEdit(Long replyNumber, String replyEditContent) {
		// TODO Auto-generated method stub
		return mapper.replyEdit(replyNumber, replyEditContent);
	}

}

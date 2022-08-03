package com.jongeon.mybatisboard.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jongeon.mybatisboard.domain.ReplyVO;
import com.jongeon.mybatisboard.service.ReplyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class ReplyController {
	private ReplyService replyService;
	
	//##### 댓글 목록 : Ajax로 통신 #####
	@PostMapping("/replyList")
	@ResponseBody
	public List<ReplyVO> replyList(@RequestBody Map<String, Object> params){
		// params.get("postNumber") -> Integer로 넘어온다 Long.valueOf을 사용하여 long타입으로 변경
		Long postNumber = Long.valueOf((Integer) params.get("postNumber")); 
		
		List<ReplyVO> replyVO = replyService.replyList(postNumber);
		
		return replyVO;
	}
	
	// ##### 댓글 등록 #####
	@PostMapping("/replyRegister")
	@ResponseBody
	public Long replyRegister(@RequestBody Map<String, Object> params) {
//		1. json 객체에서 mbrIdx, postNumber, replyContent를 가져와 변수에 담는다.
			Long mbrIdx = Long.parseLong((String) params.get("mbrIdx")); // view에서 가져온 mbrIdx가 타입이 String
			Long postNumber = Long.valueOf((Integer)params.get("postNumber")); //  Long.valueOf을 사용하여 long타입으로 변경
			String replyContent = (String) params.get("replyContent");

			// 댓글 등록 메소드 실행
			Long replyRegister = replyService.replyRegister(mbrIdx, postNumber, replyContent);
//		return null;
		return replyRegister;
	}
}

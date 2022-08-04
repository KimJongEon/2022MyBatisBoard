package com.jongeon.mybatisboard.domain;

import lombok.Data;

@Data
 // 필드의 순서에 상관없이 객체 생성 가능, 원하는 필드만 가지고 객체 생성가능 //필드 : 클래스에 포함된 변수
public class PagingVO {
	private int listSize = 5;                //초기값으로 목록개수를 10으로 셋팅

	private int rangeSize = 5;            //초기값으로 페이지범위를 10으로 셋팅

	private int page;

	private int range;

	private int postListCnt;

	private int pageCnt;

	private int startPage;

	private int startList;

	private int endPage;

	private boolean prev;

	private boolean next;

	public void pageInfo(int page, int range, int postListCnt) {

		this.page = page;

		this.range = range;

		this.postListCnt = postListCnt;

		

		//전체 페이지수 

		this.pageCnt = (int) Math.ceil((double)postListCnt/listSize);
//		this.pageCnt = (int) Math.ceil(postListCnt/listSize);
//		System.out.println(" 전체 페이지 수 확인 : "+this.pageCnt);
		

		//시작 페이지

		this.startPage = (range - 1) * rangeSize + 1 ;

		

		//끝 페이지

		this.endPage = range * rangeSize;

				

		//게시판 시작번호

		this.startList = (page - 1) * listSize;

		

		//이전 버튼 상태

		this.prev = range == 1 ? false : true;

		

		//다음 버튼 상태

//		this.next = endPage > pageCnt ? true : false;
		this.next = pageCnt > endPage ? true : false;
//		System.out.println("엔드페이지 : "+endPage);
//		System.out.println("페이지카운트 : "+pageCnt);
		if (this.endPage > this.pageCnt) {

			this.endPage = this.pageCnt;

			this.next = false;

		}

	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



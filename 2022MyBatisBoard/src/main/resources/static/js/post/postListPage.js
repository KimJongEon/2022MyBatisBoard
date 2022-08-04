////$(function(){
////	
////	
////
////
////}); // function() END
////
// 페이징 처리▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
// 이전 버튼 이벤트
function fn_prev(page, range, rangeSize) {
	var path = window.location.pathname;
	var page = ((range - 2) * rangeSize) + 1;
	var range = range - 1;

	var url = path;

	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}

// 페이지 번호 클릭
function fn_pagingVO(page, range) {
	var path = window.location.pathname;
	var url = path;
	
//	console.log("page : " + page);
//	console.log("range : " + range);
//	console.log("path : " + path);
	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}

// 다음 버튼 이벤트
function fn_next(page, range, rangeSize) {
	var path = window.location.pathname;
	var page = parseInt((range * rangeSize)) + 1;
	var range = parseInt(range) + 1;

	var url = path;

	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}
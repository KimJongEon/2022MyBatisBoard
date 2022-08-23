//날짜 변환 함수
	function date_to_str(format)
	{
	    var year = format.getFullYear();
	    var month = format.getMonth() + 1;
	    if(month<10) month = '0' + month;
	    var date = format.getDate();
	    if(date<10) date = '0' + date;
	    var hour = format.getHours();
	    if(hour<10) hour = '0' + hour;
	    var min = format.getMinutes();
	    if(min<10) min = '0' + min;
	    var sec = format.getSeconds();
	    if(sec<10) sec = '0' + sec;

	    return year + "-" + month + "-" + date + " " + hour + ":" + min + ":" + sec;
	}

$(function(){
//	var mbrEmail = $("#mbrEmail").text(); //세션에 저장된 아이디 값
	var postNumber = parseInt($("#postNumber").text()); // 해당 글 번호
	var mbrIdx = $("#mbrIdx").text();
	var mbrNickName = $("#mbrNickName").text();
	
	//댓글 수정, 삭제 변수
	var replyNumber; // 클릭 시 해당 댓글 번호를 가져와서 담는다
	var replyEditButton; // 댓글 수정 버튼
	var replyEditBtnDiv;
	var OriginalReplyContent;
	
	replyList(); // 댓글 목록 불러오는 함수 호출
	
	// 댓글 목록 
	function replyList(){
		var data = {'postNumber' : postNumber};
		var jsonData = JSON.stringify(data);
		$.ajax({
			type : "POST",
			data : jsonData,
			datatType : "json",
			contentType : "application/json; charset=UTF-8",
			url : "/replyList",
			success : function(data) {
				var html = "";
				if(data.length > 0){   
	                for(i=0; i<data.length; i++){
						// 날짜 형식 변경
						var sysdate = new Date(data[i].replyDate);
	                	sysdate = date_to_str(sysdate);
						
	                    html += "<div class='border-bottom border-info' style='margin-bottom : 2.5%'>";
//	                    html += "<span class='replyNumber' style='display : none;'> "+ data[i].replyNumber +"</span>";
	                    html += "<span class='r_mbrIdx' style='display : none;'>" +data[i].mbrIdx+ "</span>";
	                    html += "<span class='h3 text-primary r_mbrNickName'>" +data[i].mbrNickName + "</span>";
	                    html += "<span class='delEditButton' style='position: absolute; '>" +
//	                    		"<span class='text-secondary replyDate' >" +'('+ data[i].replyDate + ')'+"</span>";
								"<span class='text-secondary replyDate' >" +'('+ sysdate + ')'+"</span>"; //날짜 형식 변경

	                    if(mbrIdx == data[i].mbrIdx){
	                    	html+="<input type='button' class='btn btn-danger replyDelBtn' value='삭제' name='" +  data[i].replyNumber + "'" + "/>";
	                    	html+="<input type='button' class='btn btn-success replyEditBtn' value='수정' name='" +  data[i].replyNumber + "'" + "/>";
	                    }
	                    html +=	"</span>";
	                    html += "<p class='replyContent' style=' padding-top : 1.5%; padding-bottom : 0.5%;'>" + data[i].replyContent + " </p>";
	                    html += "</div>";
	                    
//	                    console.log(html);
	                }
	                
	            } else {
	                
	                html += "<div>";
	                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
	                html += "</table></div>";
	                html += "</div>";
	                
	            }
	            
	            $(".replyList").html(html);
				
			}
		}); // Ajax End
	}; // replyList() End


	// 댓글 등록 ajax
	$("#replyRegister").click(function() {
		if(!mbrIdx){
			alert("로그인이 필요합니다.");
			window.location.replace("/loginPage"); // 이동 후 뒤로 가기 버튼 클릭 시 홈으로 이동함
		}else{
			var replyContent = $("#replyTextArea").val();
			var spaceCheck = /\s/g; // 스페이스바, 탭 으로 댓글 내용 넣었을 때 체크 하기 위한 변수
			if(replyContent.match(spaceCheck)){ //공백만 존재 할 때
				alert("댓글 내용을 입력 해주세요");
				
			}else{ // 공백만 존재 하지 않을 때
				var data = { 'mbrIdx': mbrIdx, 'postNumber': postNumber, 'replyContent': replyContent };
				var jsonData = JSON.stringify(data);
				$.ajax({
					type: "POST",
					data: jsonData,
					dataType: 'json',
					contentType: "application/json; charset=UTF-8",
					url: "/replyRegister",
					success: function(result) {
						//				console.log(result);
						if (result == 1) {
							replyList();
							$("#replyTextArea").val("");
						} else {
							alert("댓글 등록 실패");
							window.location.href = "/";
						}
					}
				}); // ajax END
			} // replyContent.match(spaceCheck) else End
		} // !mbrIdx else End
	}); // click function END	
	
	// 댓글 삭제
	$(document).on("click", ".replyDelBtn" , function() { // Jquery 동적 생성 태그 이벤트 부여
		var replyDelConfirm = confirm("정말 삭제 하시겠습니까?");
		
		if(replyDelConfirm){ // yes
		replyNumber = this.name; //해당 댓글의 replyNumber를 가져온다
		var data = {'replyNumber' : replyNumber};
		var jsonData = JSON.stringify(data); // ajax로 data 보낼때 json형식으로 파싱해서 보낸다.
		$.ajax({
			type : "POST",
			data : jsonData,
			datatType : "json",
			contentType : "application/json; charset=UTF-8",
			url : "/replyDel",
			success : function(result) {
				if (result == 1) { // 댓글 성공 삭제 시
						replyList();
				}else {
						alert("댓글 삭제 실패");
						window.location.href = "/";
				}
			} // success End
		}); // Ajax End
		
		}else{ // no
			replyList();
		}
		
		
	}); // 댓글 삭제 End
	
	// 댓글 수정 버튼 클릭 시
	$(document).on("click", ".replyEditBtn" , function() { // Jquery 동적 생성 태그 이벤트 부여
		replyNumber = this.name;
		var html = "";
		replyEditBtnDiv = $(this).closest("div"); // 해당 댓글의 상위 div
		OriginalReplyContent = $(replyEditBtnDiv).find('.replyContent').text(); // div 하위 태그 중 class=replyContent 의 text값 -> 댓글 내용   
		replyEditButton = $(this);
		$(this).remove(); // 수정 버튼 제거
		$(replyEditBtnDiv).find('.replyContent').remove(); // 댓글 내용 span 태그 제거
		
		html = 
		html += "<div class='input-group replyDiv'>"
		html += "<textarea class='form-control' id='replyEditTextArea' rows='3'>"
		html += OriginalReplyContent
		html += "</textarea>"
		html += "<input type='button' class='btn btn-secondary replyEditCancel' value='취소'/>"
		html += "<input type='button' id='replyEdit' class='btn btn-success replyEdit' value='등록'/>"
		html += "</div>";	
		
		$(replyEditBtnDiv).append(html);
		//댓글 텍스트 에어리어 (취소, 등록 버튼 두개 필요)
		
		
	}); // 댓글 수정 버튼 클릭 시 End
	
	// 댓글 수정 '취소' 버튼 클릭 시
	$(document).on("click", ".replyEditCancel" , function() { // Jquery 동적 생성 태그 이벤트 부여
		var replyNameVal = replyEditButton.attr('name'); // 수정 버튼 name 값
		
		// 1. 댓글 수정 텍스트 박스 삭제
		$(this).closest("div").remove(); // 댓글 수정 text-area 상위 div 삭제
		
		// 2. 수정 버튼 재 활성화
		var html = "";
		html =
		html += "<input type='button' class='btn btn-success replyEditBtn' value='수정' name='" +  replyNameVal + "'" + "/>";
		$(replyEditBtnDiv).find('.delEditButton').append(html); // 수정 버튼 append
		
		// 3. 댓글 내용 재 활성화
		var html = "";
		html += "<p class='replyContent' style=' padding-top : 1.5%; padding-bottom : 0.5%;'>" + OriginalReplyContent + " </p>";
		$(replyEditBtnDiv).append(html); // 댓글 내용 append
		
		//replyList(); 로 댓글을 다시 불러올 때 DB에 계속 접근하기 때문에 댓글이 많을 시 속도 저하가 우려
		
		
	}); // 댓글 수정 취소 버튼 클릭 시 End
	
	// 댓글 수정 '등록' 버튼 클릭 시
	$(document).on("click", "#replyEdit", function() {
		if(!mbrIdx){
			alert("로그인이 필요합니다.");
			window.location.replace("/loginPage"); // 이동 후 뒤로 가기 버튼 클릭 시 홈으로 이동함
		}else{
			var replyEditContent = $("#replyEditTextArea").val();
			var data = { 'replyNumber': replyNumber, 'replyEditContent': replyEditContent };
			var jsonData = JSON.stringify(data);
			
			$.ajax({
				type: "POST",
				data: jsonData,
				dataType: 'json',
				contentType: "application/json; charset=UTF-8",
				url: "/replyEdit",
				success: function(result) {
					if (result == 1) { // 댓글 수정 성공
						replyList();
					} else {
						alert("댓글 수정 실패");
						window.location.href = "/";
					}
				}
			}); // ajax END
		} // else End
	}); // click function END
	
	
}); // function() END
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
						
	                    html += "<div>";
	                    html += "<span class='replyNumber' style='display : none;'> "+ data[i].replyNumber +"</span>";
	                    html += "<span class='r_mbrIdx' style='display : none;'>" +data[i].mbrIdx+ "</span>";
	                    html += "<span class='text-primary r_mbrNickName'>" +data[i].mbrNickName + "</span>";
	                    html += "<span style='position: absolute; '>" +
//	                    		"<span class='text-secondary replyDate' >" +'('+ data[i].replyDate + ')'+"</span>";
								"<span class='text-secondary replyDate' >" +'('+ sysdate + ')'+"</span>"; //날짜 형식 변경

	                    if(mbrIdx == data[i].mbrIdx){
//	                    	html+= "<a href='#' onclick='delReply(); return false;'>테스트</a>";
	                    	html+="<input type='button' class='btn btn-dark r_delBtn' value='삭제' name='" +  data[i].replyNumber + "'" + "/>";
	                    }
	                    html +=	"</span>";
	                    html += "<br/>";
	                    html += "<span class='replyContent'>" + data[i].replyContent + " </span>";
	                    html += "<hr/>";
	                    
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
//			window.location.href="/loginPage";
			window.location.replace("/loginPage"); // 이동 후 뒤로 가기 버튼 클릭 시 홈으로 이동함
		}else{
			var replyContent = $("#replyTextArea").val();
			var data = { 'mbrIdx': mbrIdx, 'postNumber': postNumber, 'replyContent': replyContent };
			
//			if(replyContent == ""){//
//				
//			}
			
			var jsonData = JSON.stringify(data);
			//		console.log(jsonData);

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
		} // else End
	}); // click function END	
	
	// 댓글 삭제
	$(document).on("click", ".r_delBtn" , function() { // Jquery 동적 생성 태그 이벤트 부여
		var replyNumber = this.name;
		console.log(replyNumber);
		
		var data = {'replyNumber' : replyNumber};
		var jsonData = JSON.stringify(data);
		
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
	}); // 댓글 삭제 End
	
	
}); // function() END
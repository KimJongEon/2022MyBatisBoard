$(function(){
//	var mbrEmail = $("#mbrEmail").text(); //세션에 저장된 아이디 값
	var postNumber = parseInt($("#postNumber").text()); // 해당 글 번호
	var mbrIdx = $("#mbrIdx").text();
	var mbrNickName = $("#mbrNickName").text();
//	console.log(mbrEmail);
	console.log(postNumber);
	console.log(mbrIdx);
	console.log(sessionStorage);
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
//				console.log(data);
				if(data.length > 0){   
	                for(i=0; i<data.length; i++){
	                    html += "<div>";
	                    html += "<span class='replyNumber' style='display : none;'> "+ data[i].replyNumber +"</span>";
	                    html += "<span class='r_mbrIdx' style='display : none;'>" +data[i].mbrIdx+ "</span>";
	                    html += "<span class='text-primary r_mbrNickName'>" +data[i].mbrNickName + "</span>";
	                    html += "<span style='position: absolute; '>" +
	                    		"<span class='text-secondary replyDate' >" +'('+ data[i].replyDate + ')'+"</span>";
//	                    if(user_id == data[i].user_id){
//	                    	html+= "<a href='#' onclick='delReply(); return false;'>테스트</a>";
//		                    html+="<input type='button' class='btn btn-dark r_delBtn' value='삭제' name=" + data[i].r_no + "/>";
//	                    }
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
	
	
	
}); // function() END
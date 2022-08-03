$(function(){
	var idCheck = false;
	var pwCheck = false;
	
	// 회원가입시 아이디, 비밀번호, 비밀번호확인, 이름, 휴대폰번호 체크
	$("#signUpBtn").click(function(){
		var pwd1=$("#mbrPassword_01").val();
        var pwd2=$("#mbrPassword_02").val();
        
        if(idCheck == false){
			alert("중복된 아이디입니다.");
			$("#mbrEmail").focus();
			return false;
		}
        
		if($("#mbrEmail").val().length == 0){
			alert("아이디를 입력해주세요."); //알림창 띄우기
			$("#mbrEmail").focus(); // 아이디(이메일) 입력창으로 포커스
			return false; //submit을 막기위해 리턴 false 해줌
		}
	
        if(pwd1 != "" || pwd2 != ""){
            if(pwd1 != pwd2){
            	alert("비밀번호를 정확히 입력해주세요");
    			$("#mbrPassword_01").focus();
    			return false;
            }
        }
        
		if($("#mbrPassword_01").val().length == 0){
			alert("비밀번호를 정확히 입력해주세요");
			$("#mbrPassword_01").focus();
			return false;
		}
		
		if($("#mbrPassword_02").val().length == 0){
			alert("비밀번호를 정확히 입력해주세요");
			$("#mbrPassword_02").focus();
			return false;
		}

		if($("#mbrNickName").val().length == 0){
			alert("닉네임을 입력해주세요.");
			$("#mbrNickName").focus();
			return false;
		}
	}); //click function END
	
// 비밀번호 확인
//	$(function(){
        $("input").blur(function(){
        	
            var pwd1=$("#mbrPassword_01").val();
            var pwd2=$("#mbrPassword_02").val();
            
            if(pwd1 != "" || pwd2 != ""){
                if(pwd1 == pwd2){
                    $("#pw-success").show();
                    $("#pw-danger").hide();
                    pwCheck = true;
                    
                    if(idCheck == true && pwCheck == true){
                    	$("#signUpBtn").attr("disabled", false);
                    }else if (idCheck == false || pwCheck == false){
                    	$("#signUpBtn").attr("disabled", true);
                    }
//                    console.log("pwCheck 확인하기 : " + pwCheck);
                }else{
                    $("#pw-success").hide();
                    $("#pw-danger").show();
                    pwCheck = false;
                    
                    if(idCheck == true && pwCheck == true){
                    	$("#signUpBtn").attr("disabled", false);
                    }else if (idCheck == false || pwCheck == false){
                    	$("#signUpBtn").attr("disabled", true);
                    }
//                    console.log("pwCheck 확인하기 : " + pwCheck);
                }    
            }
        }); // input keyup END
//    });
	
        //아이디 중복 체크
        $("#mbrEmail").blur(function(){
        	var mbrEmail = $('#mbrEmail').val();
//        	console.log(mbrEmail);
        	
        	$.ajax({
        		type : "GET",
        		data :{ "mbrEmail" : mbrEmail},
        		url : "/mbrEmailCheck",
        		success : function(data){
//        			console.log(data);
        			
        			if(mbrEmail == ""){
        				$("#id-write").show();
        				$("#id-success").hide();
        				$("#id-danger").hide();
        				idCheck = false;
        				
        				if(idCheck == true && pwCheck == true){
                        	$("#signUpBtn").attr("disabled", false);
                        }else if (idCheck == false || pwCheck == false){
                        	$("#signUpBtn").attr("disabled", true);
                        }
        				
        			}else if(data == "fail"){
        				$("#id-success").hide();
                        $("#id-danger").show();
                        $("#id-write").hide();
                        idCheck = false;
                        
                        if(idCheck == true && pwCheck == true){
                        	$("#signUpBtn").attr("disabled", false);
                        }else if (idCheck == false || pwCheck == false){
                        	$("#signUpBtn").attr("disabled", true);
                        }
                        
        			}else if(data == "success"){
        				$("#id-success").show();
                        $("#id-danger").hide();
                        $("#id-write").hide();
                        idCheck = true;
                        
                        if(idCheck == true && pwCheck == true){
                        	$("#signUpBtn").attr("disabled", false);
                        }else if (idCheck == false || pwCheck == false){
                        	$("#signUpBtn").attr("disabled", true);
                        }
//                        console.log(idCheck);
        			}
        		}
        	}); //ajax END
        }); //mbrEmail keyup END
        
}); // function() END
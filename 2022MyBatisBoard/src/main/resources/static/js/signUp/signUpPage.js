$(function() {
	var idCheck = false; //mbrEmail 확인을 위한 변수 선언
	var pwCheck = false; // mbrPassword 확인을 위한 변수 선언
	var nickNameCheck = false; // mbrNickName 확인을 위한 변수 선언
	
	
	// 회원가입시 아이디, 비밀번호, 비밀번호확인, 이름, 휴대폰번호 체크
	$("#signUpBtn").click(function() {
		var pwd1 = $("#mbrPassword_01").val();
		var pwd2 = $("#mbrPassword_02").val();

		if (idCheck == false) {
			alert("중복된 아이디입니다.");
			$("#mbrEmail").focus();
			return false;
		}

		if ($("#mbrEmail").val().length == 0) {
			alert("아이디를 입력해주세요."); //알림창 띄우기
			$("#mbrEmail").focus(); // 아이디(이메일) 입력창으로 포커스
			return false; //submit을 막기위해 리턴 false 해줌
		}

		if (pwd1 != "" || pwd2 != "") {
			if (pwd1 != pwd2) {
				alert("비밀번호를 정확히 입력해주세요");
				$("#mbrPassword_01").focus();
				return false;
			}
		}

		if ($("#mbrPassword_01").val().length == 0) {
			alert("비밀번호를 정확히 입력해주세요");
			$("#mbrPassword_01").focus();
			return false;
		}

		if ($("#mbrPassword_02").val().length == 0) {
			alert("비밀번호를 정확히 입력해주세요");
			$("#mbrPassword_02").focus();
			return false;
		}

		if ($("#mbrNickName").val().length == 0) {
			alert("닉네임을 입력해주세요.");
			$("#mbrNickName").focus();
			return false;
		}

		var mbrEmail = $("#mbrEmail").val();
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

		if (exptext.test(mbrEmail) == false) {

			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			

			alert("이메일형식이 올바르지 않습니다.");

			$("#mbrEmail").focus();
			return false;
		}
	}); //click function END


// ##### mbrPassword_01, mbrPassword_02 ##### Start
	// 비밀번호 확인
	$("input").blur(function() {

		var pwd1 = $("#mbrPassword_01").val();
		var pwd2 = $("#mbrPassword_02").val();

		if (pwd1 != "" || pwd2 != "") {
			if (pwd1 == pwd2) {
				$("#pw-success").show();
				$("#pw-danger").hide();
				pwCheck = true;

				if (idCheck == true && pwCheck == true && nickNameCheck == true) {
					$("#signUpBtn").attr("disabled", false);
				} else if (idCheck == false || pwCheck == false || nickNameCheck == false) {
					$("#signUpBtn").attr("disabled", true);
				}
			} else {
				$("#pw-success").hide();
				$("#pw-danger").show();
				pwCheck = false;

				if (idCheck == true && pwCheck == true && nickNameCheck == true) {
					$("#signUpBtn").attr("disabled", false);
				} else if (idCheck == false || pwCheck == false || nickNameCheck == false) {
					$("#signUpBtn").attr("disabled", true);
				}
				//                    console.log("pwCheck 확인하기 : " + pwCheck);
			}
		}
	}); // input keyup END
// ##### mbrPassword_01, mbrPassword_02 ##### End


// ##### mbrEmail ##### Start
	//아이디 중복 체크
	$("#mbrEmail").blur(function() {
		var mbrEmail = $('#mbrEmail').val();

		if (mbrEmail == "") {
			$("#id-write").show();
			$("#id-success").hide();
			$("#id-emailCheck").hide();
			$("#id-danger").hide();
			idCheck = false;

			if (idCheck == true && pwCheck == true && nickNameCheck == true) {
				$("#signUpBtn").attr("disabled", false);
			} else if (idCheck == false || pwCheck == false || nickNameCheck == false) {
				$("#signUpBtn").attr("disabled", true);
			} // else if End

		} else if ($("#mbrEmail").val().length > 0) {
			$.ajax({
				type: "GET",
				data: { "mbrEmail": mbrEmail },
				url: "/mbrEmailCheck",
				success: function(data) {
					if (data == "fail") { //아이디가 중복일때
						$("#id-success").hide();
						$("#id-danger").show();
						$("#id-write").hide();
						$("#id-emailCheck").hide();
						idCheck = false;

						if (idCheck == true && pwCheck == true && nickNameCheck == true) {
							$("#signUpBtn").attr("disabled", false);
						} else if (idCheck == false || pwCheck == false || nickNameCheck == false) {
							$("#signUpBtn").attr("disabled", true);
						}

					} else if (data == "success") { //아이디 중복이 아닐 때

						var mbrEmail = $("#mbrEmail").val();
						var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

						if (exptext.test(mbrEmail) == false) {

							//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			
							$("#id-success").hide();
							$("#id-danger").hide();
							$("#id-write").hide();
							$("#id-emailCheck").show();
							$("#signUpBtn").attr("disabled", true);
							//						$("#mbrEmail").focus();
						} else {
							$("#id-success").show();
							$("#id-danger").hide();
							$("#id-write").hide();
							$("#id-emailCheck").hide();
							idCheck = true;

							if (idCheck == true && pwCheck == true && nickNameCheck == true) {
								$("#signUpBtn").attr("disabled", false);
							} else if (idCheck == false || pwCheck == false || nickNameCheck == false) {
								$("#signUpBtn").attr("disabled", true);
							}
							//                        console.log(idCheck);
						}
					}
				}
			}); //ajax END
		}
	}); //mbrEmail.blur END
// ##### mbrEmail ##### End


// ##### mbrNickName ##### Start
	// 닉네임(mbrNickName) 중복 체크
	$("#mbrNickName").blur(function() {
		var mbrNickName = $('#mbrNickName').val();

		if (mbrNickName == "") {
			$("#mbrNickName-success").hide();
			$("#mbrNickName-danger").hide();
			$("#mbrNickName-write").show();
			idCheck = false;

			if (idCheck == true && pwCheck == true && nickNameCheck == true) {
				$("#signUpBtn").attr("disabled", false);
			} else if (idCheck == false || pwCheck == false || nickNameCheck == false) {
				$("#signUpBtn").attr("disabled", true);
			} // else if End

		} else if ($("#mbrNickName").val().length > 0) {
			$.ajax({
				type: "GET",
				data: { "mbrNickName": mbrNickName },
				url: "/mbrNickNameCheck",
				success: function(data) {
					if (data == "fail") { // 닉네임이 중복일때
						$("#mbrNickName-success").hide();
						$("#mbrNickName-danger").show();
						$("#mbrNickName-write").hide();
						nickNameCheck = false;

						if (idCheck == true && pwCheck == true && nickNameCheck == true) {
							$("#signUpBtn").attr("disabled", false);
						} else if (idCheck == false || pwCheck == false || nickNameCheck == false) {
							$("#signUpBtn").attr("disabled", true);
						}

					} else if (data == "success") { // 닉네임 중복이 아닐 때
						$("#mbrNickName-success").show();
						$("#mbrNickName-danger").hide();
						$("#mbrNickName-write").hide();
						nickNameCheck = true;

						if (idCheck == true && pwCheck == true && nickNameCheck == true) {
							$("#signUpBtn").attr("disabled", false);
						} else if (idCheck == false || pwCheck == false || nickNameCheck == false) {
							$("#signUpBtn").attr("disabled", true);
						}
					}
				} // success: function(data) End
			}); //ajax END
		} // $("#mbrNickName").val().length > 0 End
	}); // mbrNickName.blur END
// ##### mbrNickName ##### End

}); // function() END
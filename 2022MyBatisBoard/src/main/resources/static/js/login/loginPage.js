$(function() {
	//로그인 버튼 클릭시
	$("#loginBtn").click(function() {
		// 아이디가 이메일 형식인지 확인함
		var mbrEmail = $("#mbrEmail").val();
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

		if (exptext.test(mbrEmail) == false) {

			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			

			alert("이메일형식이 올바르지 않습니다.");

			$("#mbrEmail").focus();
			return false;
		}	
	}); //click function END
	
}); // function() END
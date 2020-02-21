$(".log-btn").click(function(){
		var userName = $("#userName").val();
		var password = $("#password").val();
		$.post("/login/query",{"userName":userName,"password":password},function(result){
			if(result==true){
					window.location.href="/beHome";
				
			}else{
            	$('.num-err').removeClass('hide').find('em').text("账号或密码错误，请重新输入");
            	$('.pass-err').removeClass('hide').find('em').text("账号或密码错误，请重新输入");
            	return false;
			}
		})
	})//--------------
	
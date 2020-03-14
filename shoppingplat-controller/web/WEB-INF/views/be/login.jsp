<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="/static/css/base.css">
		<link rel="stylesheet" href="/static/css/reg.css">
	</head>
	<body>
		<div id="ajax-hook"></div>
		<div class="wrap">
			<div class="wpn">
				<div class="form-data pos">
					<a href=""><img src="" class="head-logo"></a>
					<div class="change-login">
						<p class="account_number on">账号登录</p>
					</div>
					<div class="form1">
						<p class="p-input pos">
							<input type="text" id="userName" value="admin" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
							<span class="tel-warn num-err hide"><em></em></span>
						</p>
						<p class="p-input pos">
							<input type="password" id="password" value="123456" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
							<span class="tel-warn pass-err hide">
							<em></em></span>
						</p>
					</div>

					<div class="r-forget cl">
						<a href="./getpass.html" class="y"></a>
					</div>
					<button class="lang-btn  log-btn">登录</button>
					<div class="third-party">
						<!-- <a href="#" class="log-qq icon-qq-round"></a> -->
					</div>
					<p class="right">后台管理系统</p>
				</div>
			</div>
		</div>
	<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/static/js/login/login.js"></script>
	</body>
</html>

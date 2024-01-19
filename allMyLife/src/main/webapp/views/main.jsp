<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	<title>Main</title>
</head>
<body>
	<div>
		<video autoplay loop muted >
			<source src="resources/images/Sea.mp4" type="video/mp4">
		</video>
	</div>
	
	<div id="mainForm">
		<div class="mainLogo">
			<div>
				<h1>AllMyLife</h1>
				<p>Welcome to my own platform</p>
			</div>
		</div>
		
		<div id="loginForm">
		<!-- 카카오 로그인 javascript
		 	<a id="kakao-login-btn" href="/kakaoLogin" onclick="window.open(this.href, '_blank', 'width=400, height=600'); return false;">
  				<img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222" alt="카카오 로그인 버튼" />
			</a>
		 -->	
			<a id="kakao-login-btn" onclick="kakaoLoginForRestAPI()">
  				<img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222" alt="카카오 로그인 버튼" />
			</a>
			<p id="token-result"></p>
		</div>
	</div>
</body>
<script>
function kakaoLoginForRestAPI() {
	$.ajax({
		url: "/kakaoLoginForRestAPI",
	    type: "GET",
	    async: false,
	    success: function(data) 
		{ debugger;
	    	location.href = data;
	    },
	    error: function() 
		{
	       console.log("AJAX Request 실패");
	    }
	});	
}

</script>

</html>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="resources/js/main.js?t=<%= new java.util.Date() %>"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css?t=<%= new java.util.Date() %>">
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
				<h1 style="font-size:40px;">AllMyLifes</h1>
				<p>Welcome to my own platform</p>
			</div>
		</div>
		
		<div id="loginForm">
		<!-- 카카오 로그인 javascript
		 	<a id="kakao-login-btn" href="/kakaoLogin" onclick="window.open(this.href, '_blank', 'width=400, height=600'); return false;">
  				<img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222" alt="카카오 로그인 버튼" />
			</a>
			<p id="token-result"></p>
		 -->	
		 <!-- 카카오 로그인 REST_API
			<a id="kakao-login-btn" onclick="kakaoLoginForRestAPI()">
  				<img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222" alt="카카오 로그인 버튼" />
			</a>
			<p id="token-result"></p>
		 -->
		 	<div class="login-item">
		 		<p class="login-label">ID</p>
		 		<input type="text" name="id" id="id" class="login-input" autocomplete="off"/>
		 	</div>
		 	<div class="login-item">
		 		<p class="login-label">Password</p>
		 		<input type="password" name="password" id="password" class="login-input" autocomplete="off"/>
		 	</div>
		 	
		 	<div class="login-sub-item">
		 		<p><a href="/Mypage">Forgot Id ?</a></p>
		 		<p><a href="/findPwd">Forgot Password ?</a></p>
		 		<p class="pull-left"><a href="/register">Register</a></p>
		 		<input id="submit" type="submit" class="login pull-right" value="Log In">
		 	</div>
		</div>
	</div>
</body>
</html>

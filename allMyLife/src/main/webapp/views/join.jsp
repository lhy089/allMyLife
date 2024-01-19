<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="resources/js/join.js?t=<%= new java.util.Date() %>"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/join.css?t=<%= new java.util.Date() %>">
	<title>Join</title>
</head>
<body>
	<div id="mainForm">
	
		<div class="mainLogo">
			<div>
				<h1>Register</h1>
				<p>Please enter your information</p>
			</div>
		</div>
		
		<div id="joinForm">
			<div>
				<div class="join-item">
					<p class="join-label">Email</p>
					<input type="text" name="email" id="email" class="join-input" autocomplete="off"/>
<!-- 					<input id="mailAuthentication" type="button" class="join pull-right" value="메일인증"> -->
				</div>
			</div>
			<div class="row ">
				<div class="join-item">
					<p class="join-label">ID</p>
					<input type="text" name="id" id="id" class="join-input" autocomplete="off"/>
				</div>
			</div>
			<div class="row ">
				<div class="join-item">
					<p class="join-label">Password</p>
					<input type="password" name="password" id="password" class="join-input" autocomplete="off"/>
				</div>
			</div>
			<div class="row ">
				<div class="join-item gender">
					<p class="join-label">gender</p>
					<div>
						<input class="with-gap" name="gender" type="radio" id="male" value="남" required /> 
						<label for="male">Male</label>
						<input class="with-gap" name="gender" type="radio" id="female" value="여" required /> 
						<label for="female">Female</label>
					</div>
				</div>
			</div>
			<div class="row">
				<input id="submit" type="submit" class="join pull-right" value="Register">
			</div>
		</div>
	</div>
</body>
</html>
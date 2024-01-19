<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<meta name="description" content="카카오 로그인 API javascript 연동용 페이지 입니다.">
<!-- 카카오톡 로그인 javascript-->
	<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.6.0/kakao.min.js"
		integrity="sha384-6MFdIr0zOira1CHQkedUqJVql0YtcZA1P0nbPrQYJXVJZUkTk/oX4U9GhUIs3/z8" crossorigin="anonymous"></script>
	<title>KakaoLogin</title>
</head>
<body>

</body>
<script>
// 카카오톡 로그인 javascript
	Kakao.init('ba3d44b3cbec316b28a91c59496e013a');
	Kakao.Auth.authorize({
  		redirectUri: 'http://allMyLife.com/kakaoLogin',
  		prompt: 'login'
	});
	Kakao.API.request({
		url: '/v2/user/me',
	  	data: {
			property_keys: ['kakao_account.profile_nickname'],
	  	},
	}).then(function(response) { debugger;
	    console.log(response);
	}).catch(function(error) {debugger;
	    console.log(error);
	});
//  카카오톡 로그인 javascript
</script>
</html>

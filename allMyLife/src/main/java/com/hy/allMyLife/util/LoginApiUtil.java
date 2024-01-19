package com.hy.allMyLife.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Handles requests for the application home page.
 */
public class LoginApiUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginApiUtil.class);
	
	/* 카카오 로그인 API */
	public static String CLIENT_ID = "23286ef6fb3c233bbc490400dbd7f4f3";	// 앱 REST API 키 ([내 애플리케이션] > [앱 키]에서 확인 가능)
	public static String REDIRECT_URI = "http://allMyLife.com/kakaoLogin";	// 인가 코드를 전달받을 서비스 서버의 URI ([내 애플리케이션] > [카카오 로그인] > [Redirect URI]에서 등록)
	public static String RESPONSE_TYPE = "code";							// code로 고정
	public static String GRANT_TYPE = "authorization_code"; 				// authorization_code 로 고정
	
	public static String AUTHORIZE_URL = "https://kauth.kakao.com/oauth/authorize";
	public static String TOKEN_URL = "https://kauth.kakao.com/oauth/token";
	public static String USERINFO_URL = "https://kapi.kakao.com/v2/user/me";
	/* 카카오 로그인 API */
	
}

package com.hy.allMyLife.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.allMyLife.service.MainService;
import com.hy.allMyLife.util.LoginApiUtil;


/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainService mainService;
	
	/**
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String cover(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "main";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "join";
	}
	
	/**
	 * 카카오 로그인 화면 연동
	 */
	@RequestMapping(value = "/kakaoLoginForRestAPI", method = RequestMethod.GET)
	@ResponseBody
	public String kakaoLoginForRestAPI(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("Welcome kakaoLoginForRestAPI! ");
			
	    String client_id = LoginApiUtil.CLIENT_ID;		
	    String redirect_uri = LoginApiUtil.REDIRECT_URI;	
	    String response_type = LoginApiUtil.RESPONSE_TYPE;						// code로 고정
		
	    String reqUrl = LoginApiUtil.AUTHORIZE_URL + "?client_id="+client_id+"&redirect_uri="+redirect_uri+"&response_type="+response_type+"&prompt=login";
	    
	    return reqUrl;
	    
	}
	 
	/**
	 * 카카오 로그인
	 */
	@RequestMapping(value = "/kakaoLogin", method = RequestMethod.GET)
		public String kakaoLogin(@RequestParam(value = "code", required = false) String code, Model model) throws Exception {
			logger.info("Welcome kakaoLogin! code : " + code);
					
			String access_Token = mainService.getTokenForKakaoLogin(code);
			Map<String,String> userInfo = mainService.getUserInfoForKakaoLogin(access_Token);
		
	        model.addAttribute("userInfo", userInfo);
	        
	        // to-do 카카오로 로그인
	        
	        return "main";
	}
	
	
}

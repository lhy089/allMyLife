package com.hy.allMyLife.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.hy.allMyLife.util.LoginApiUtil;


/**
 * Handles requests for the application home page.
 */
@Service
public class MainService {
	
	private static final Logger logger = LoggerFactory.getLogger(MainService.class);
	
	public String getTokenForKakaoLogin(String code) throws Exception 
	{	
		String data = makeKakaoLoginDataForToken(code); 
        JsonElement element = connectToServerForKakaoToken(data);
        
        String access_Token = element.getAsJsonObject().get("access_token").getAsString();
		String refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

		System.out.println("access_token : " + access_Token);
		System.out.println("refresh_token : " + refresh_Token);
		
		return access_Token ; 
	}
	
	public String makeKakaoLoginDataForToken(String code) throws Exception 
	{	
		StringBuilder sb = new StringBuilder();
		
        sb.append("grant_type="+LoginApiUtil.GRANT_TYPE);
        sb.append("&client_id="+LoginApiUtil.CLIENT_ID);
        sb.append("&redirect_uri="+LoginApiUtil.REDIRECT_URI);
        sb.append("&code=" + code);

		return sb.toString();
	}
	
	public Map<String,String> getUserInfoForKakaoLogin(String access_token) throws Exception 
	{	
        JsonElement element = connectToServerForKakaoUserInfo(access_token);
        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
        String nickname = properties.getAsJsonObject().get("nickname").getAsString();
        
        Map<String,String> data = new HashMap<String,String>();
        data.put("nickname", nickname);
		
		return data;
	}
	
	public JSONObject connectToServer(String data, String reqUrl) throws Exception {
		
		URL url = null;
	    String readLine = null;
	    StringBuilder buffer = null;
	    OutputStream outputStream = null;
	    BufferedReader bufferedReader = null;
	    BufferedWriter bufferedWriter = null;
	    HttpURLConnection urlConnection = null;
	    
	    int connTimeout = 30000;
	    int readTimeout = 30000;
	    
	    try 
	    {
	        url = new URL(reqUrl);
	        
	        urlConnection = (HttpURLConnection)url.openConnection();
	        urlConnection.setRequestMethod("POST");
	        urlConnection.setConnectTimeout(connTimeout);
	        urlConnection.setReadTimeout(readTimeout);
	        urlConnection.setRequestProperty("Content-Type", "pplication/x-www-form-urlencoded;charset=utf-8");
	        urlConnection.setDoOutput(true);
	        urlConnection.setInstanceFollowRedirects(true);
	        
	        outputStream = urlConnection.getOutputStream();
	        
	        bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
	        bufferedWriter.write(data);
	        bufferedWriter.flush();
	        
	        buffer = new StringBuilder();
	        if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) 
	        {
	            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
	            while((readLine = bufferedReader.readLine()) != null) 
	            {
	                buffer.append(readLine).append("\n");
	            }
	        }
	        else 
	        {
	            buffer.append("\"code\" : \""+urlConnection.getResponseCode()+"\"");
	            buffer.append(", \"message\" : \""+urlConnection.getResponseMessage()+"\"");
	        }
	    }
	    catch(Exception ex) 
	    {
	        ex.printStackTrace();
	    }
	    finally 
	    {
	        try 
	        {
	            if (bufferedWriter != null) { bufferedWriter.close(); }
	            if (outputStream != null) { outputStream.close(); }
	            if (bufferedReader != null) { bufferedReader.close(); }
	        }
	        catch(Exception ex) 
	        { 
	            ex.printStackTrace();
	        }
	    }
	    
	    JSONParser jsonParser = new JSONParser();
	    System.out.println("결과 : " + buffer.toString());
	    JSONObject jsonObj = (JSONObject) jsonParser.parse(buffer.toString());
     
        return jsonObj;
	}
	
	public JsonElement connectToServerForKakaoToken(String data) throws Exception {

		JsonElement element = null;
        String reqURL = LoginApiUtil.TOKEN_URL;
		
		try {
			URL url = new URL(reqURL);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			//  URL연결은 입출력에 사용 될 수 있고, POST 혹은 PUT 요청을 하려면 setDoOutput을 true로 설정해야함.
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			//	POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(data);
			bw.flush();

			//    결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			//    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			//    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			element = parser.parse(result);

			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return element;
	}
	
	public JsonElement connectToServerForKakaoUserInfo(String data) throws Exception {

		JsonElement element = null;
        String reqURL = LoginApiUtil.USERINFO_URL;
		
		try {
			URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + data);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);
            
            InputStream stream = conn.getErrorStream();
            String response = "";
		    if (stream != null) {
		    		Scanner scanner = new Scanner(stream);
			        scanner.useDelimiter("\\Z");
			        response = scanner.next();
			    			
			    System.out.println("error response : " + response);
		    }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            element = parser.parse(result);

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return element;
	}
}

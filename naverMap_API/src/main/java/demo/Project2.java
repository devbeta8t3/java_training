package demo;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Project2 {

	private static String clientID = "czr2gkaxus";
	private static String secretKey = "xEYUx6Mcb7hB5xRDZgtKqB5hcdph234XTAR3cnnd";
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("주소를 입력: ");
		String address = scanner.nextLine();
		scanner.close();
		
        StringBuilder urlBuilder = new StringBuilder("https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="); /*URL*/
        urlBuilder.append(URLEncoder.encode(address,"UTF-8")); /*주소를 url인코딩하여 붙임*/
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientID);//클라이언트id
        conn.setRequestProperty("X-NCP-APIGW-API-KEY", secretKey);//키값
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader br;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
        	br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
        	br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        String result = br.readLine();
        
        br.close();
        conn.disconnect();
        
//      System.out.println(result);	// json 방식으로 받기 위해 아래 코드로 변경
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
        JSONArray arr = (JSONArray)jsonObject.get("addresses");

        for(Object one : arr) {
        	JSONObject ob = (JSONObject)one;
        	//System.out.println(employee.toString());
        	System.out.println("address:" + ob.get("roadAddress"));
        	System.out.println("jibunAddress:" + ob.get("jibunAddress"));
        	System.out.println("경도:" + ob.get("x"));
        	System.out.println("위도:" + ob.get("y"));
		
			String x = (String)ob.get("x");
			String y = (String)ob.get("y");
			String z = (String)ob.get("roadAddress");
			
			mapService(x, y ,z);
        }
	}
	
	private static void mapService(String x, String y, String address) throws IOException {
		// 위도,경도 값을 가지고 지도이미지를 받아오기
		String mapUrl = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
		String pos = URLEncoder.encode(x + " " + y, "UTF-8");
		mapUrl += "center=" + x + "," + y;
		mapUrl += "&level=16&w=700&h=500";
		mapUrl += "&markers=type:t|size:mid|pos:" + pos + "|label:" + URLEncoder.encode(address, "UTF-8");
		
		URL url = new URL(mapUrl);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 연결설정
		conn.setRequestMethod("GET"); // 요청방법 "GET"
		
		conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientID);
		conn.setRequestProperty("X-NCP-APIGW-API-KEY", secretKey);
		
		int responseCode = conn.getResponseCode();
		
		if (responseCode == 200) { // http 상태 정상일때
			InputStream is = conn.getInputStream(); // 이미지 받기위한 입력스트림
			Image image = ImageIO.read(is); //이미지 객체생성
			// 랜덤한 이름으로 파일 생성
			String tempname = Long.valueOf(new Date().getTime()).toString();
			File f = new File(tempname + ".jpg");   
			f.createNewFile();
			ImageIO.write((RenderedImage) image, "jpg", f);
			is.close();
		} 
		else { // 에러 발생
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			conn.disconnect();
			System.out.println(response.toString());
		}
		
	}
}

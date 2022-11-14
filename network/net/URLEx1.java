package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLEx1 {

	public static void main(String[] args) {
		
		String str = "https://search.naver.com:80/search.naver?"	// :80 포트번호, 기본값이 80이므로 생략가능
					+ "where=nexearch&sm=top_hty&fbm=1&ie=utf8&"
					+ "query=java#top";	// #top : 뒤로가기 했을때 기존화면영역으로 돌아옴.
		
		try {
			/* url 정보보기 */
			URL url = new URL(str);
			System.out.println("Protocol : " +url.getProtocol());
			System.out.println("Host : " +url.getHost());
			System.out.println("Port : " +url.getPort());
			System.out.println("Path : " +url.getPath());
			System.out.println("Query : " +url.getQuery());
			System.out.println("Filename : " +url.getFile());
			System.out.println("ref : " +url.getRef());	//
			
			/* 네이버 코드 가져오기 (콘솔 출력) */
			url = new URL("https://www.naver.com/");
			BufferedReader br = new BufferedReader(
								new InputStreamReader(url.openStream(), "UTF-8"));
			String line = "";
			while (true) {
				line = br.readLine();
				if (line==null) break;
				System.out.println(line);
			}
			br.close();
			System.out.println("End~~~~~~~~~~~~~~~~~~");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

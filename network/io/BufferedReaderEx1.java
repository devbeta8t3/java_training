package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderEx1 {

	public static void main(String[] args) {

//		InputStream is = System.in;	// 스트림
//		InputStreamReader isr = new InputStreamReader(is);	// 문자
//		BufferedReader br = new BufferedReader(isr);	// 버퍼기능
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 한줄로 표현
		
		String s = "";
		while (true) {
			try {
				s = br.readLine();
				System.out.println("출력 : " +s);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//--while
		
	}

}

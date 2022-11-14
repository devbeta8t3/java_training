package io;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderEx1 {

	public static void main(String[] args) {
		// Reader : 스트림의 한글 처리 클래스
		InputStream is = System.in;
		
		// 바이트 단위의 data를 문자 단위로 처리하는 클래스
		Reader reader = new InputStreamReader(is);		// Reader가 추상클래스
//		Writer writer = new OutputStreamWriter();		// 위로 반대의 경우 Writer - OutputStream
		
		try {
			while (true) {
				int i = reader.read();
				if (i==-1) break;
				System.out.print((char)i);
			}
			reader.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

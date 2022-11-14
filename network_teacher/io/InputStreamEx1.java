package io;

import java.io.InputStream;

/*I/O : Input / Output*/

public class InputStreamEx1 {

	public static void main(String[] args) {
		
		InputStream is = System.in;//키보드 (System.out : 콘솔창)
		while(true) {
			try {
				int i = is.read();//내부적으로 쓰레트 대기 상태
				//A -> 64 -> 1byte 변환되어 vm에 전달
				if(i==-1) break;//ctrl+z
				System.out.print((char)i);
			} catch (Exception e) {
				e.printStackTrace();//예외의 모든 경로까지 출력
			}
		}//--while
	}//--main
	
}//--class
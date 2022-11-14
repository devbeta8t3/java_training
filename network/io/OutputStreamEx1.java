package io;

import java.io.OutputStream;

/* I/O : Input / Output */
public class OutputStreamEx1 {

	public static void main(String[] args) {

		int i = 'A';
		char c = 'b';
		char c1 = '김';
		
		try {
			// 콘솔창에 출력스트림을 빨대로 꽂았다.
			OutputStream os = System.out;
			os.write(i);
			os.write(c);
			os.write(c1);
			os.flush();	// 스트림에 남아있는 data를 비운다. (InputSteam에는 flush가 없다.)
			os.close();	// 사용하지 않는 스트림은 반드시 닫는다.
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//--main

}//--class

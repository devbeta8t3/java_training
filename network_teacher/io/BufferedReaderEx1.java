package io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderEx1 {

	public static void main(String[] args) {
		/*InputStream is = System.in;//��Ʈ��
		InputStreamReader isr = new InputStreamReader(is);//����
		BufferedReader br = new BufferedReader(isr);//���۱��*/
		
		BufferedReader br = 
					new BufferedReader(
				new InputStreamReader(System.in));
		
		String s = "";
		while(true) {
			try {
				s = br.readLine();
				System.out.println("��� :" + s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//--while
	}
}





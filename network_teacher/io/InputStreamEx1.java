package io;

import java.io.InputStream;

/*I/O : Input / Output*/

public class InputStreamEx1 {

	public static void main(String[] args) {
		
		InputStream is = System.in;//Ű���� (System.out : �ܼ�â)
		while(true) {
			try {
				int i = is.read();//���������� ����Ʈ ��� ����
				//A -> 64 -> 1byte ��ȯ�Ǿ� vm�� ����
				if(i==-1) break;//ctrl+z
				System.out.print((char)i);
			} catch (Exception e) {
				e.printStackTrace();//������ ��� ��α��� ���
			}
		}//--while
	}//--main
	
}//--class
package io;

import java.io.OutputStream;

public class OutputStreamEx1 {

	public static void main(String[] args) {
		int i = 'A';
		char c = 'b';
		char c1 = '��';
		try {
			//�ܼ�â�� ��½�Ʈ���� ����� �žѴ�.
			OutputStream os = System.out;
			os.write(i);
			os.write(c);
			os.write(c1);
			os.flush();//��Ʈ���� ���� �ִ� data�� ����
			os.close();//������� ���� ��Ʈ���� �ݵ�� �ݴ´�.
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//--main

}
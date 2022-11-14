package io;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderEx1 {

	public static void main(String[] args) {
		//Reader : ��Ʈ���� �ѱ� ó�� Ŭ����
		InputStream is = System.in;
		//����Ʈ ������ data�� ���� ������ ó���ϴ� Ŭ����
		Reader reader  = new InputStreamReader(is);
		try {
			while(true) {
				int i = reader.read();
				if(i==-1) break;
				System.out.print((char)i);
			}
			reader.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
	public static void main(String[] args) {
		//aaa.txt�� ������ ���� ����.���� ��� ����
		try {
			FileReader fr = new FileReader("io/aaa.txt");
			int i;
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
			fr.close();
			System.out.println("\nEnd~~~~~~~~~~~~");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}


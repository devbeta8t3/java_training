package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
	public static void main(String[] args) {
		//aaa.txt는 동일한 폴더 존재.절대 경로 가능
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


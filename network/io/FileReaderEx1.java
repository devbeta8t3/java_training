package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {

	public static void main(String[] args) {
		// aaa.txt는 동일한 폴더에 존재. 절대경로 사용도 가능
		try {
			FileReader fr = new FileReader("io/aaa.txt");
			int i;
			while ((i=fr.read()) != -1) {	// 파일의 제일 마지막이 -1이다. 즉, 마지막이 올때까지 Loop하면서 read()한다.
				System.out.print((char)i);
			}
			fr.close();
			System.out.println("\nEnd~~~~~~~~~~~~~~~~~~~~~");
			
		} catch (FileNotFoundException e) {	// 순차적으로 catch 하므로 하위 Exception 부터 catch 처리해야한다.
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}

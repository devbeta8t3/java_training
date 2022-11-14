package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx1 {

	public static void main(String[] args) {

		String str = "Dream as if you'll live forever,\n"
				+ "Live as if you'll die today - 제임스딘";
		
		try {
			FileWriter fw = new FileWriter("io/bbb.txt");
			fw.write(str);
			
			fw.flush();
			fw.close();
			System.out.println("End~~~~~~~~~~~~~~~~~~~");
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}

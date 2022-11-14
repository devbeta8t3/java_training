package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileCopyEx1 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("원본파일 >> ");
			String sFile = sc.nextLine();
			System.out.print("복사파일 >> ");
			String cFile = sc.nextLine();
			
			FileReader fr = new FileReader("io/" +sFile);
			FileWriter fw = new FileWriter("io/" +cFile);	// 파일 생성
			
			int c;
			while ((c=fr.read()) != -1) {	// 파일 내용의 마지막값은 -1 즉, 끝까지 읽는다.
				fw.write(c);
			}
			
			fw.close();
			fr.close();
			System.out.println("Copy End...................");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

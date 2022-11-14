package java_Ch04_ClassObject_Ex;

import java.util.Scanner;

public class DicApp {

	Scanner scanner = new Scanner(System.in);
	
	public void run() {
	System.out.println("한영 단어 검색 프로그램입니다.");
	
	while (true) {
		
		System.out.print("한글 단어? ");
		String word = scanner.next();
		
		if (word.equals("그만")) {
			System.out.println("종료합니다...");
			break;
		}
		System.out.println(word+ "은(는) " + Dictionary.kor2Eng(word));
		
	
	}
		
	}
	
}

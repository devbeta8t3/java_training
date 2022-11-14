package java_Ch07_Generic_Collection;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapDicEx {

	public static void main(String[] args) {
		// 영어 단어와 한글 단어의 쌍을 저장하는 HashMap 컬렉션 생성
		HashMap<String, String> dic = new HashMap<String, String>();
		
		// 3개의 (key, value) 쌍을 dic에 저장
		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		// 영어단어를 입력받아 한글단어 검색. "exit" 입력시 종료
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("찾고싶은 단어는? ");
			String eng = sc.next();
			
			if (eng.equals("exit")) {
				System.out.println("종료합니다...");
				break;
			}
			
			// 해시맵에서 key의 value 검색
			String kor = dic.get(eng);
			if (kor==null)
				System.out.println(eng+ "는 없는 단어입니다.");
			else
				System.out.println(kor);
		}
		sc.close();
	}

}

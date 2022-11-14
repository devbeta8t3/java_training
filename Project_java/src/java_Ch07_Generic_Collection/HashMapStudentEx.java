package java_Ch07_Generic_Collection;

import java.util.*;

public class HashMapStudentEx {

	public static void main(String[] args) {
		// 학생 이름과 Student 객체를 쌍으로 저장하는 HashMap 컬렉션 생성
		HashMap<String, Student> map = new HashMap<String, Student>();
		
		// 3a명의 학생 저장
		map.put("황기태", new Student(1, "010-111-1111"));
		map.put("이재문", new Student(2, "010-222-2222"));
		map.put("김남윤", new Student(3, "010-333-3333"));
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("검색할 이름은? ");
			String name = sc.next();
			
			if (name.equals("exit")) {
				System.out.println("종료합니다...");
				break;
			}
			
			// 해시맵에서 key의 value 검색
			Student student = map.get(name); 	// 이름에 해당하는 value (Student 객체)
			if (student==null)
				System.out.println(name+ "은(는) 없는 단어입니다.");
			else
				System.out.println("id:" +student.id+ ", 전화:" +student.tel);
		}
		sc.close();
	}

}

class Student {
	int id;
	String tel;
	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}
}

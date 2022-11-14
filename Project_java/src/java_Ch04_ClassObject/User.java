package java_Ch04_ClassObject;

public class User {		// 1-1. 클래스 만들기
	
	// 클래스 만들때, 구성하는 멤버 3가지 (옵션, 필수아님)
	// 1) 멤버변수
	// 2) 생성자 (메소드)
	// 3) (일반/멤버) 메소드
	// 2-1. 객체 만들기????? 는 언제?
	
	// 1) 멤버변수 만들기
	String name;							// 멤버 변수
	int age;								// 멤버 변수
	
	// 2) 생성자 (메소드) 만들기
	User() {  // class와 이름이 같다.	
		name = "";							// 멤버변수의 초기값 설정할 수 있다.
		age = 10;							// 멤버변수의 초기값 설정할 수 있다.
		System.out.println("생성자입니다!");
	}

	// 3) (일반/멤버) 메소드
	void printName() {
		System.out.println("이름은 "+name);
	}
	
	int changeAge(int gap) {				// gap: 매개 변수
		int new_age = 0;					// new_age: changeAge 메소드의 지역변수
		new_age = age + gap;
		
		return new_age;
	}
}

package java_Ch05_Inheritance;

public class Student extends Person {

	public void set() {
		age = 30;
		name = "홍길동";
		height = 175;
		
//		weight = 99;	// 오류. 슈퍼 클래스의 private은 접근 불가
		
		setWeight(99);	// private 멤버 weight은 setWeight()으로 간접 접근
	}
}

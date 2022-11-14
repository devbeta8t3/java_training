package java_Ch05_Inheritance;

public class UsingOverride {

	public static void main(String[] args) {
		// Generated by SH Lee
		// p.38 예제 5-5의 Shape, Line, Rect, Circle 클래스 활용

		Shape start;
		Shape last;
		Shape obj;
		
		// 링크드 리스트로 도형 생성하여 연결
		start = new Line();		// Line 객체 연결
		last = start;
		
		obj = new Rect();		// Rect 객체 연결
		last.next = obj;
		last = obj;
		
		obj = new Line();		// Line 객체 연결
		last.next = obj;
		last = obj;
		
		obj = new Circle();		// Circle 객체 연결
		last.next = obj;
		
		// 모든 도형 출력
		Shape p = start;
		while(p != null) {
			p.draw();
			p = p.next;
		}
	}

}

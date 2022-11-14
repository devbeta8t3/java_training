package java_Ch05_Inheritance;

public class Shape {	// 슈퍼 클래스

	public Shape next;
	public Shape() {
		next = null;
	}
	
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape {
	public void draw() {				// 메소드 오버라이딩
		System.out.println("Line");
	}
}

class Rect extends Shape {				// 메소드 오버라이딩
	public void draw() {
		System.out.println("Rect");
	}
}

class Circle extends Shape {			// 메소드 오버라이딩
	public void draw() {
		System.out.println("Circle");
	}
}

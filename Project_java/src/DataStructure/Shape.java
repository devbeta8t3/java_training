package DataStructure;

public abstract class Shape {

	private Shape next;
	
	public Shape() {				// 객체 초기화
		next = null;
	}
	
	public void setNext(Shape obj) {		// obj를 가리켜라.
		next = obj;
	}
	
	public Shape getNext() {				// next가 가리키는 주소
		return next;
	}
	
	public abstract void draw();
}

class Line extends Shape {
	@Override
	public void draw() {
		System.out.println("Line");
	}
}

class Rect extends Shape {
	@Override
	public void draw() {
		System.out.println("Rect");
	}
}

class Circle extends Shape {
	@Override
	public void draw() {
		System.out.println("Circle");
	}
}
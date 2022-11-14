package java_Ch05_Inheritance_Ex;

class Rect implements Shape {
	
	int a;
	int b;
	
	public Rect(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public void draw() {
		System.out.println(a+ "X" +b+ " 크기의 사각형입니다.");
	}
	
	public double getArea() {
		return a*b;
	}
	
}

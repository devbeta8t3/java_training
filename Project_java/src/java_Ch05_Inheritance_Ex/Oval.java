package java_Ch05_Inheritance_Ex;

class Oval implements Shape {
	
	int a;
	int b;
	
	public Oval(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public void draw() {
		System.out.println(a+ "X" +b+ " 사각형에 내접하는 타원입니다.");
	}
	
	public double getArea() {
		return (a/2)*(b/2)*PI;
	}
	
}

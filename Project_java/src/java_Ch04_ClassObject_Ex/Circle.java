package java_Ch04_ClassObject_Ex;

public class Circle {
	private double x;
	private double y;
	private int radius;
	
	public Circle(double x, double y, int radius) {
		// 내용 작성 1
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void show() {
		// 내용 작성 2
		System.out.println("(" +x+ ", " +y+ ")" +radius);
	}
}

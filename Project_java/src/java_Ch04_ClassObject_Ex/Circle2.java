package java_Ch04_ClassObject_Ex;

public class Circle2 {
	private double x;
	private double y;
	int radius;
	
	public Circle2(double x, double y, int radius) {
		// 내용 작성 1
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void show2() {
		// 내용 작성 2
		System.out.println("가장 면적이 큰 원은 (" +x+ ", " +y+ ")" +radius);
	}
}

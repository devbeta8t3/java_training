package java_Ch04_ClassObject_Ex;

public class Rectangle {
	int x;
	int y;
	int width;
	int height;
	
	public Rectangle(int x, int y, int width, int height) {		// 생성자
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void show() {
		System.out.println("r(" +x+ ", " +y+ ")에서 크기가 " +width+ "x" +height+ "인 사각형");
	}
	
	public int square() {
		int area = width * height;
		return area;
	}
	
	boolean contains(Rectangle r) {
		if ((this.x <= r.x) && 
			(this.y <= r.y) && 
			(this.x+this.width) >= (r.x+r.width) && 
			(this.y+this.height) >= (r.y+r.height)) {
			
			return true;
		}
		else
			return false;
	}
	
}

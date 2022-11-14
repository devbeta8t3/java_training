package java_Ch05_Inheritance_Ex;

class ColorPoint2 extends Point {

	// 연습문제 6
	
	private String color;
	
	public ColorPoint2() {
		super(0,0);
		setColor("BLACK");
	}
	public ColorPoint2(int x, int y) {
		super(x, y);
	}
	
	public void setXY(int x, int y) {
		move(x, y);
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return color+ "색의 " + "(" +getX()+ "," +getY()+ ")의 점"; 
	}
	
}

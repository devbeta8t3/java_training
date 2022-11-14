package java_Ch05_Inheritance_Ex;

class ColorPoint extends Point {

	// 연습문제 5
	
	private String color;
	
	public ColorPoint(int x, int y, String color) {
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

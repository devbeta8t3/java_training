package java_Ch05_Inheritance_Ex;

class PositivePoint extends Point {		// 연습문제 8
	
	
	public PositivePoint() {
		super(0, 0);
	}
	
	public PositivePoint(int x, int y) {
		move(x, y);		
	}
	
	public void move(int x, int y) {
		if (x>=0 && y>=0) {
			super.move(x,y);
		}
	}

	public String toString() {
		return "(" +getX()+ "," +getY()+ ")의 점";
	}
	
}

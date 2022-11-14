package java_Ch05_Inheritance;

public class Point {

	private int x;
	private int y;
	
	public void set(int x, int y) {		// 점의 좌표 입력
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() {		// 점의 좌표 출력
		System.out.println("(" +x+ ", " +y+ ")");
	}
}

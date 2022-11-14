package java_Ch05_Inheritance;

public class ColorPoint extends Point {		// Point를 상속받은 ColorPoint 선언

	private String color;
	
	public void setColor(String color) {	// 점의 컬러 입력
		this.color = color;
	}
	
	public void showColorPoint() {			// 컬러 점의 좌표 출력
		System.out.print(color);
		showPoint();				// Point 클래스의 showPoint() 메소드 호출
	}
}

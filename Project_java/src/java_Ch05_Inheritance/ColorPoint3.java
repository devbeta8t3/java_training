package java_Ch05_Inheritance;

public class ColorPoint3 extends Point3 {
	
	private String color;
	
	public ColorPoint3(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	public void showColorPoint3() {
		System.out.print(color);
		showPoint3();
	}

}

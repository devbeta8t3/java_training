package java_Ch05_Inheritance_Ex;

public class Ex_05 {

	public static void main(String[] args) {
		// Generated by SH Lee
		
		ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
		cp.setXY(10, 20);
		cp.setColor("RED");
		
		String str = cp.toString();
		
		System.out.println(str+ "입니다.");
	}

}

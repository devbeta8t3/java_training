package java_Ch05_Inheritance_Ex;

public class Ex_06 {

	public static void main(String[] args) {
		// Generated by SH Lee

		ColorPoint2 zeropoint = new ColorPoint2();
		System.out.println(zeropoint.toString()+ "입니다.");
		
		ColorPoint2 cp = new ColorPoint2(10,10);
		
		cp.setXY(5,5);
		cp.setColor("RED");
		
		System.out.println(cp.toString()+ "입니다.");
	}

}

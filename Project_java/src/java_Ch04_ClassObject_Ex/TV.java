package java_Ch04_ClassObject_Ex;

public class TV {

	String brand;
	int year;
	int size;
	
	public TV(String b, int y, int s) {
		brand = b;
		year = y;
		size = s;
	}
	void show() {
		System.out.println(brand+"에서 만든 " +year+ "년형 " +size+ "인치 TV");
	}
}		// review - 멤버변수는 private 하시오.

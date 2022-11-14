package java_Ch04_ClassObject_Ex;

public class Grade {
	
	private int math;
	private int science;
	private int english;
	
	Grade(int m, int s, int e) {
		math = m;
		science = s;
		english = e;				
	}
	
	float average() {
		float avg = (float)(math + science + english) / 3;
		return avg;
	}
}		

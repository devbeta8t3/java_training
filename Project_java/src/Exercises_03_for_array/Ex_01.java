package Exercises_03_for_array;

public class Ex_01 {

	public static void main(String[] args) {
		// Generated by SH Lee
		int sum = 0;
		
		for (int i=0; i<100; i=i+2) {
			sum = sum + i;
		}
		
		System.out.println("100 미만 짝수들의 합 : "+sum);
	}

}

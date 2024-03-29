package Exercises_03_for_array;

public class Ex_10 {

	public static void main(String[] args) {
		// Generated by SH Lee
		int rInt[][] = new int[4][4];
		int m;
		int n;
		
		for (int count=0; count<10; count++) {	// 랜덤숫자 10개 삽입 카운트
			
			m = (int)(Math.random()*4);		// 랜덤 배열 행 위치
			n = (int)(Math.random()*4);		// 랜덤 배열 열 위치
			
			if (rInt[m][n] == 0)			// 랜덤 배열 위치의 값이 0이면 1~10 랜덤 정수 삽입
				rInt[m][n] = (int)(Math.random()*10 + 1);
			else
				count--;					// 랜덤 배열 위치의 값이 0 아니면 카운트 무효
		}
		
		for (int i=0; i<rInt.length; i++) {		// 배열 출력
			for (int j=0; j<rInt[i].length; j++) {
				System.out.print(rInt[i][j] + "\t");
			}
			System.out.println();
		}
	}
}		// review : while continue를 사용하는게 더 깔끔할수도...

package Exercises_03_for_array;
import java.util.Scanner;

public class Ex_08 {

	public static void main(String[] args) {
		// Generated by SH Lee
		Scanner a = new Scanner(System.in);
		System.out.print("정수 몇 개?");
		int num = a.nextInt();
		int iArray[] = new int[num];
		
		// review 후 예외처리 작성
		if (num<=0 || num>=100) {
			System.out.println("1~99의 갯수를 입력하세요.");
			a.close();
			return;
		}
		
		for (int i=0; i<iArray.length; i++) {
			iArray[i] = (int)(Math.random()*100 + 1);
			
			for (int j=0; j<i; j++) {
				if (iArray[i] == iArray[j]) {
					i--;
					break;
				}
			}
		}
		
		for (int k=0; k<iArray.length; k++)
			System.out.print(iArray[k]+ " ");
		
		a.close();
	}

}		// review - 예외처리 요구, 입력 숫자크기 0이하 100 이상일 때 
package Exercises_02_if;
import java.util.Scanner;

public class Ex_01 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		float usd = 0;
		
		System.out.print("원화를 입력하세요(단위: 원)>>");
		int krw = a.nextInt();
		usd = (float) krw / 1216;
		
		System.out.print(krw + "원은 $");
		System.out.printf("%.2f", usd);
		System.out.print("입니다.");
		
		a.close();
	}

}

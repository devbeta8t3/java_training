package Exercises_02_if;
import java.util.Scanner;

public class Ex_11_ifelse {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int m = 0;
		
		System.out.print("달을 입력하세요(1~12)>>");
		m = a.nextInt();
				
		if ((m == 3)||(m == 4)||(m == 5))
			System.out.println("봄");
		else if ((m == 6)||(m == 7)||(m == 8))
			System.out.println("여름");
		else if ((m == 9)||(m == 10)||(m == 11))
			System.out.println("가을");
		else if ((m == 12)||(m == 1)||(m == 2))
			System.out.println("겨울");
		else
			System.out.println("잘못 입력하셨습니다.");			
	}

}

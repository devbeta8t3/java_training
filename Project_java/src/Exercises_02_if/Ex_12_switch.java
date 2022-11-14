package Exercises_02_if;
import java.util.Scanner;

public class Ex_12_switch {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int x = 0;
		int y = 0;
		String s;
				
		System.out.print("연산>>");
		x = a.nextInt();
		s = a.next();
		y = a.nextInt();
		
		switch (s) {
			case "+":
				System.out.println(x + "+" + y + "의 계산 결과는 " + (x+y));
				break;
			case "-":
				System.out.println(x + "-" + y + "의 계산 결과는 " + (x-y));
				break;
			case "*":
				System.out.println(x + "*" + y + "의 계산 결과는 " + (x*y));
				break;
			case "/":
				if (y == 0)
					System.out.println("0으로 나눌 수 없습니다.");
				else
					System.out.println(x + "/" + y + "의 계산 결과는 " + (x/y));
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			
		a.close();
		}
	}

}

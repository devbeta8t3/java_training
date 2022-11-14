package Exercises_02_if;
import java.util.Scanner;

public class Ex_06 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int x = 0;
		int y = 0;
		System.out.print("1~99 사이의 정수를 입력하시오>>");
		int z = a.nextInt();
		
		x = z / 10;
		y = z % 10;
		
		System.out.print("박수");
		if ((x == 3) || (x == 6) || (x == 9))
			System.out.print("짝");
		if ((y == 3) || (y == 6) || (y == 9))
			System.out.print("짝");
	}	// self-review : count++ 개념, 예외처리, 박수없음 생각할 것

}

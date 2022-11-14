package Exercises_02_if;
import java.util.Scanner;

public class Ex_05 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int x = 0;
		int y = 0;
		int z = 0;
		System.out.print("정수 3개를 입력하시오(구분은 빈칸으로 하세요)>>");
		x = a.nextInt();
		y = a.nextInt();
		z = a.nextInt();
		
		if (((x + y) > z) && ((y + z) > x) && ((z + x) > y))
			System.out.println("Yes! 삼각형이 됩니다.");
		else
			System.out.println("No! 삼각형이 안됩니다.");
	}

}	// self-review : OR 사용하는게 성능면에서 우수하다.

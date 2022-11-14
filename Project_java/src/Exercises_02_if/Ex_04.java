package Exercises_02_if;
import java.util.Scanner;

public class Ex_04 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int x = 0;
		int y = 0;
		int z = 0;
		System.out.print("정수 3개 입력(구분은 빈칸으로 하세요)>>");
		x = a.nextInt();
		y = a.nextInt();
		z = a.nextInt();
		
		if (((x >= y) && (x <= z)) || ((x <= y) && (x >= z)))
			System.out.println("중간값은 " + x);
		else if (((y >= x) && (y <= z)) || ((y <= x) && (y >= z)))
			System.out.println("중간값은 " + y);
		else
			System.out.println("중간값은 " + z);
	}

}

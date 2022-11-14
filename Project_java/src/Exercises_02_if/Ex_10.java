package Exercises_02_if;
import java.util.Scanner;

public class Ex_10 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int x1 = 0;
		int y1 = 0;
		float r1 = 0;
		int x2 = 0;
		int y2 = 0;
		float r2 = 0;
		int d = 0;
		float distance = 0;
		
		System.out.print("첫번째 원의 중심과 반지름 입력>>");
		x1 = a.nextInt();
		y1 = a.nextInt();
		r1 = a.nextFloat();
		
		System.out.print("두번째 원의 중심과 반지름 입력>>");
		x2 = a.nextInt();
		y2 = a.nextInt();
		r2 = a.nextFloat();

		d = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
		distance = (float) Math.sqrt(d);
		
		if (distance <= (r1+r2))
			System.out.println("두 원은 서로 겹친다.");
		else
			System.out.println("두 원은 서로 겹치지 않는다.");
		
		a.close();
	}

}

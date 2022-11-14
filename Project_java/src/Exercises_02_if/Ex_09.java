package Exercises_02_if;
import java.util.Scanner;

public class Ex_09 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int c1 = 0;
		int c2 = 0;
		float r = 0;
		int x = 0;
		int y = 0;
		int d = 0;
		float distance = 0;
		
		System.out.print("원의 중심과 반지름 입력(구분은 빈칸으로 하세요)>>");
		c1 = a.nextInt();
		c2 = a.nextInt();
		r = a.nextFloat();
		
		System.out.print("점 (x, y) 입력(구분은 빈칸으로 하세요)>>");
		x = a.nextInt();
		y = a.nextInt();
		
		d = (c1-x)*(c1-x) + (c2-y)*(c2-y);
		distance = (float) Math.sqrt(d);
		
		if (distance <= r)
			System.out.println("점 (" + x + ", " + y + ")는 원 안에 있다.");
		else
			System.out.println("점 (" + x + ", " + y + ")는 원 밖에 있다.");
		
		a.close();
	}

}	// Math.pow() 함수도 있다. 거듭제곱

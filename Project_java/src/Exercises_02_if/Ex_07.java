package Exercises_02_if;
import java.util.Scanner;

public class Ex_07 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		
		System.out.print("점 (x, y)의 좌표를 정수로 입력하시오(괄호 없이 구분은 빈칸)>>");
		int x = a.nextInt();
		int y = a.nextInt();
		
		if ((x >= 100)&&(x <= 200)&&(y >= 100)&&(y <= 200))
			System.out.println("점 (" + x + "," + y + ")는 사각형 안에 있습니다.");
		else 
			System.out.println("점 (" + x + "," + y + ")는 사각형 밖에 있습니다.");
		
		a.close();
	}

}	// done

package Exercises_02_if;
import java.util.Scanner;

public class Ex_08 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		
		System.out.print("두 점 (x1, y1), (x2, y2)의 좌표를 입력하시오(괄호 없이 구분은 빈칸)>>");
		int x1 = a.nextInt();
		int y1 = a.nextInt();
		int x2 = a.nextInt();
		int y2 = a.nextInt();
		
		if ((x1 >= 100)&&(x1 <= 200) && (y1 >= 100)&&(y1 <= 200)) // x1,y1이 사각형 내부
			System.out.println("사각형이 겹칩니다.");
		else if ((x2 >= 100)&&(x2 <= 200) && (y2 >= 100)&&(y2 <= 200)) // x2,y2가 사각형 내부
			System.out.println("사각형이 겹칩니다.");
		else if ((x1 < 100)&&(y1 < 100) && (x2 >= 100)&&(y2 >= 100)) // case 1
			System.out.println("사각형이 겹칩니다.");
		else if ((x1 < 100)&&(y1 >= 100)&&(y1 <= 200) && (x2 >= 100)) // case 2
			System.out.println("사각형이 겹칩니다.");
		else if ((x1 < 100)&&(y1 > 200) && (x2 >=100)&&(y2 <= 200)) // case 3
			System.out.println("사각형이 겹칩니다.");
		else if ((x1 >= 100)&&(x1 <= 200)&&(y1 < 100) && (y2 >= 100)) // case 4
			System.out.println("사각형이 겹칩니다.");
		else if ((x1 >= 100)&&(x1 <= 200)&&(y1 > 200) && (y2 <= 200)) // case 5
			System.out.println("사각형이 겹칩니다.");
		else if ((x1 > 200)&&(y1 < 100) && (x2 <= 200)&&(y2 >= 100)) // case 6
			System.out.println("사각형이 겹칩니다.");
		else if ((x1 > 200)&&(y1 >= 100)&&(y1 <= 200) && (x2 <= 200)) // case 7
			System.out.println("사각형이 겹칩니다.");
		else if ((x1 > 200)&&(y1 > 200) && (x2 <= 200)&&(y2 <= 200)) // case 8
			System.out.println("사각형이 겹칩니다.");
		else
			System.out.println("사각형이 겹치지 않습니다.");
		
		a.close();
	}
}
	// review : 문제에 있는 메소드를 사용하여, 입력된 직사각형 네 점이 기존 사각형에 포함되는지 검사하는 방법 고려할 것.
	// review : 예외처리 고려할 것.
	// 
	// Method 활용 (아래)
	//public static boolean inRect(int x, int y, int rect_x1, int rect_y1, int rect_x2, int rect_y2)
	//{
	//	if (x>=rect_x1 && x<=rect_x2 && y>=rect_y1 && y<=rect_y2)
	//		return true;
	//	else
	//		return false;
	//}
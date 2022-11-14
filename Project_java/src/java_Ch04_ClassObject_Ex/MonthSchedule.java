package java_Ch04_ClassObject_Ex;

import java.util.Scanner;

public class MonthSchedule {

	Scanner scanner = new Scanner(System.in);
	
	Day day[];							// 객체배열 변수 선언
	
	// 생성자	
	public MonthSchedule(int days) {
		day = new Day[days];			// day 객체배열 선언
		
		for (int i=0; i<days; i++) {
			day[i] = new Day();			// 객체 생성
		}
	}
	
	
	// 할일을 입력 받는 함수
	public void input() {
		System.out.print("날짜(1~30)? ");
		int d = scanner.nextInt();
		System.out.print("할일(빈칸없이입력)? ");
		String todo = scanner.next();
		
		day[d-1].set(todo);											// 해당 날짜에 할일 입력
		System.out.println();
	}
	
	// 날짜에 맞는 할일을 보여주는 함수		
	public void view() {
		System.out.print("날짜(1~30)? ");
		int d = scanner.nextInt();
		
		System.out.print(d+"일의 할일은 ");
		day[d-1].show();											// 해당 날짜의 할일 출력
		System.out.println();
	}
	
	// 프로그램을 종료하는 함수
	public void finish() {
		System.out.println("프로그램을 종료합니다.");						// 종료 메시지 출력
	}
	
	// 실행
	public void run() {
		
		System.out.println("이번달 스케쥴 관리 프로그램");
		
		// 1,2,3 메뉴를 선택 - 반복
		while (true) {
			
			System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
			int menu = scanner.nextInt();						// 메뉴 선택
			
			if (menu==1) 										// 메뉴 1 (( 입력 ))
				input();
			else if (menu==2)									// 메뉴 2 (( 보기 ))
				view();											
			else if (menu==3) {									// 메뉴 3 (( 끝내기 ))
				finish();
				break;
			}
			else
				System.out.println("입력이 잘못되었습니다.");
		
		}
		
		scanner.close();
	}
}

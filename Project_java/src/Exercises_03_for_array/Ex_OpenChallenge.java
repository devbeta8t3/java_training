package Exercises_03_for_array;

import java.util.Scanner;

public class Ex_OpenChallenge {

	public static void main(String[] args) {
		// Generated by SH Lee
		// 카드 맞추기 게임 (up & down)
		// 0~99 중 pc에 의해 선별된 숫자를 user가 맞추는 게임
		
		// step.1 pc가 숫자를 선별
		// step.2 user가 맞추는 과정 (입력)
		// step.3 pc가 hint를 주는 과정
		// step.4 반복
		
		Scanner sc = new Scanner(System.in);
		
		// 랜덤 정수 0~99 생성
		int card = (int)(Math.random()*100);
		int min = 0;
		int max = 99;
		char yorn;
		
//		System.out.println("랜덤 숫자 검증 0~99 : "+num);	// test 후 주석처리 
		System.out.print("카드가 선택되었습니다.");	

		// 반복 입력 while
		while (true) {
		
		// user 입력 & hint
			System.out.print(min+"~"+max+"의 정수를 입력하세요>>> ");	
			int a = sc.nextInt();
			
			// 예외 처리 - 범위를 벗어난 정수
			if (a<0 || a>99) {
				System.out.println("범위를 벗어났습니다.");
				continue;
			}
			
			// user 입력값에 따른 hint & 입력 정수범위 업데이트
			if (a>card) {
				System.out.println("더 낮게~");
				max = a-1;
			}
			else if (a<card) {
				System.out.println("더 높게~");
				min = a+1;
			}
			else if (a==card) {
				System.out.println("정답입니다.");
				System.out.print("다시 하시겠습니까? (y/n)>> ");
				yorn = sc.next().charAt(0);
				
				if (yorn=='y' || yorn=='Y') {				// 게임 재시작
					System.out.println("새로운 카드를 선택합니다.");
					card = (int)(Math.random()*100);
					min = 0;
					max = 99;
					continue;
				}
				else if (yorn=='n' || yorn=='N') {			// 게임 종료
					System.out.println("종료합니다...");
					break;
				}
				else {										// 입력 이상
					System.out.println("입력이 잘못되었습니다. 종료합니다.");
					break;
				}
			}
			else
				System.out.println("잘못된 입력입니다.");
			
		}
		sc.close();
	}
}

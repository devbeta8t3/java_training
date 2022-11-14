package Exercises_02_if;
import java.util.Scanner;

public class Ex_03 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int fifty_thou = 0;
		int ten_thou = 0;
		int one_thou = 0;
		int fiv_hund = 0;
		int one_hund = 0;
		int fifty = 0;
		int ten = 0;
				
		System.out.print("금액을 입력하시오.(단위: 원)>>");
		int k = a.nextInt(); 
		
		fifty_thou = k / 50000;
		ten_thou = (k % 50000) / 10000;
		one_thou = ((k % 50000) % 10000) / 1000;
		fiv_hund = (((k % 50000) % 10000) % 1000) / 500;
		one_hund = ((((k % 50000) % 10000) % 1000) % 500) / 100;
		fifty = (((((k % 50000) % 10000) % 1000) % 500) % 100) / 50;
		ten = ((((((k % 50000) % 10000) % 1000) % 500) % 100) % 50) / 10;
		
		System.out.println("오만원권 " + fifty_thou + "매");
		System.out.println("만원권 " + ten_thou + "매");
		System.out.println("천원권 " + one_thou + "매");
		System.out.println("오백원 " + fiv_hund + "개");
		System.out.println("백원 " + one_hund + "개");
		System.out.println("오십원 " + fifty + "개");
		System.out.println("십원 " + ten + "개");
				
	}

}

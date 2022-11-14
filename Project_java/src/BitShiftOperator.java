
public class BitShiftOperator {

	public static void main(String[] args) {
		short a = (short)0x55ff;
		short b = 0x00ff;
		
		// 비트 연산
		System.out.printf("%x\n", a & b);
		System.out.printf("%x\n", a | b);
		System.out.printf("%x\n", a ^ b);
		System.out.printf("%x\n", ~a);
		
		byte c = 20;	// 0x14
		byte d = -8;	// 0x8
		
		// 시프트 연산
		System.out.println(c << 2);	// c를 2비트 왼쪽 시프트
		System.out.println(c >> 2); // c를 2비트 오른쪽 시프트. 0 삽입
		System.out.println(d >> 2); // c를 2비트 오른쪽 시프트. 1 삽입
		System.out.printf("%x\n", d >>> 2);	// d를 2비트 오른쪽 시프트. 0 삽입
	}

}

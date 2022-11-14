
public class UnaryOperator {

	public static void main(String[] args) {
		int opr = 0;
		opr += 3;					// opr = opr +3
		System.out.println(opr++);	// opr 출력 후 증가
		System.out.println(opr);
		System.out.println(++opr); 	// opr 증가 후 출력
		System.out.println(opr);
		System.out.println(opr--); 	// opr 출력 후 증가
		System.out.println(opr);
		System.out.println(--opr); 	// opr 감소 후 출력
		System.out.println(opr);
	}

}

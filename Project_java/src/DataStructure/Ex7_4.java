package DataStructure;

public class Ex7_4 {

	public static void main(String[] args) {

		OptExp2 opt = new OptExp2();
		int result;
		String exp = "35*62/-";
		System.out.println("후위 표기식 : " +exp);
		result = opt.evalPostfix(exp);
		System.out.println("연산결과 = " +result);
	}

}

package java_Ch05_Inheritance_Ex;

class Won2Dollar extends Converter {

	// 연습문제 3
	public Won2Dollar(double r) {		// 환율 결정
		ratio = r;
	}
	public double convert(double src){
		return src/ratio;
	}
	
	public String srcString() {			// 소스 통화 단위 : 원
		return "원";
	}
	
	public String destString() {		// 목표 통화 단위 : 달러
		return "달러";
	}
	
	}

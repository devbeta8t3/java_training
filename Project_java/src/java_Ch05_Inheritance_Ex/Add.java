package java_Ch05_Inheritance_Ex;

class Add extends Calc {
	public int calculate() {
		return a+b;
	}
}

class Sub extends Calc {
	public int calculate() {
		return a-b;
	}
}

class Mul extends Calc {
	public int calculate() {
		return a*b;
	}
}

class Div extends Calc {
	public int calculate() {
		return a/b;
	}
}

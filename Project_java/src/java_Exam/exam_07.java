package java_Exam;

public class exam_07 {

	public static void main(String[] args) {
		// Generated by SH Lee
		Circle c = new Circle();
        c.paint();
        
	}

}
class Shape {
    public void draw() {
        System.out.println("Shape");
    }
}
class Circle extends Shape {
    public void draw() {
        System.out.println("Circle");
    }
    public void paint() {
        super.draw();
    }
}
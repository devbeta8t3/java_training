package java_Exam;

public class exam_04 {

	public static void main(String[] args) {
		// Generated by SH Lee
		Parent pa = new Child();
        pa.show();
	}

}
class Parent {
    public void show() {
        System.out.println("Parent");
    }
}
class Child extends Parent {
    public void show() {
        System.out.println("Child");
    }
}
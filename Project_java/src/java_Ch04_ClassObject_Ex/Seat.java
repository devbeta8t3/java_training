package java_Ch04_ClassObject_Ex;

public class Seat {

	String position[];
	
	public Seat() {
		position = new String[10];
		for (int i=0; i<position.length; i++) {
			position[i] = "---";
		}
	}
	
	public void setPosition(int num, String name) {
		position[num-1] = name;
	}
	
	public void delPosition(String name) {
		for (int i=0; i<position.length; i++) {
			if (name.equals(position[i]))
				position[i] = "---";
		}
	}
	
	public void printPosition() {
		for (int i=0; i<position.length; i++) {
			System.out.printf(position[i]+ " ");
		}
		System.out.println();
	}
	
	public String getName(int i) {
		return position[i];
	}
	
}

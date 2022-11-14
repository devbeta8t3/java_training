package java_Ch05_Inheritance_Ex;

class ColorTV extends TV {

	private int color;
	
	public ColorTV(int size, int color) {
		super(size);
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
	
	public void printProperty() {
		System.out.println(getSize()+ "인치 " +getColor()+ "컬러");
		
	}
}

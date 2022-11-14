package java_Ch05_Inheritance_Ex;

class Point3D extends Point {
	
	private int z;
	
	public Point3D(int x, int y, int z) {
		super(x,y);
		this.z = z;
	}
	
	public void moveUp() {
		z = z + 1;
	}
	
	public void moveDown() {
		z = z - 1;
	}
	
	public void move(int x, int y, int z) {
		move(x,y);
		this.z = z;
	}
	
	public int getZ() {
		return z;
	}

	public String toString() {
		return "(" +getX()+ "," +getY()+ "," +getZ()+ ")의 점";
	}
	
}

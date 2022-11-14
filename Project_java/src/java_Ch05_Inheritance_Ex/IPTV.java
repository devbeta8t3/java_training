package java_Ch05_Inheritance_Ex;

class IPTV extends ColorTV {

	private String addr;
	
	public IPTV(String addr, int size, int color) {
		super(size, color);
		this.addr = addr;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void printProperty() {
		System.out.println("나의 IPTV는 " +getAddr()+ " 주소의 " +getSize()+ "인치 " +getColor()+ "컬러");
	}
}

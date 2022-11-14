package java_Ch04_ClassObject_Ex;

public class Phone {

	private String name;
	private String tel;
	
	public Phone(String name, String tel) {
		this.setName(name);
		this.setTel(tel);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}

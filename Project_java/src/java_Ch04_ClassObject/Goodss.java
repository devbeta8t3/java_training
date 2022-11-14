package java_Ch04_ClassObject;

public class Goodss {
	Goodss(){
	}
	private String name;
	private int price;
	private int numberOfStock;
	private int sold;
	
	Goodss(String n, int p, int nStock, int s) {
		name = n;
		price = p;
		numberOfStock = nStock;
		sold = s;
	}
	
	String getName() {return name;}
	int getPrice() {return price;}
	int getNumberOfStock() {return numberOfStock;}
	int getSold() {return sold;}

}

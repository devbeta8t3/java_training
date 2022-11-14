package java_Ch04_ClassObject;
import java.util.Scanner;

public class GoodsArray {
	void runGoodsArray() {
		
		Goodss[] goodsArray;
		goodsArray = new Goodss[3];
		
		Scanner s = new Scanner(System.in);
		
		for (int i=0; i<goodsArray.length; i++) {
			
			String name = s.next();
			int price = s.nextInt();
			int n = s.nextInt();
			int sold = s.nextInt();
			goodsArray[i] = new Goodss(name, price, n, sold);
		}
		
		for (int i=0; i<goodsArray.length; i++) {
			
			System.out.print(goodsArray[i].getName() + " ");
			System.out.print(goodsArray[i].getPrice() + " ");
			System.out.print(goodsArray[i].getNumberOfStock() + " ");
			System.out.println(goodsArray[i].getSold() + " ");
		}
		s.close();		
	}
}


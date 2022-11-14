package java_Ch04_ClassObject_Ex;

public class ArrayUtil {

		public static int[] concat(int[] a, int[] b) {
			int[] c = new int[a.length + b.length];
			
			for (int i=0; i<a.length; i++) {
				c[i] = a[i];
			}
			
			for (int j=0; j<b.length; j++) {
				c[j+a.length] = b[j];
			}
			return c;
		}
		
		public static void print(int[] a) {
			System.out.print("[ ");
			
			for (int i=0; i<a.length; i++) {
				System.out.print(a[i]+ " ");
			}
			System.out.println("]");
		}
}

package java_Ch04_ClassObject;

public class ArrayParameter {

	void replaceSpace(char a[]) {
		for (int i=0; i<a.length; i++) {
			if (a[i]==' ')
				a[i] =',';
		}
	}

	void printCharArray(char a[]) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
	

}

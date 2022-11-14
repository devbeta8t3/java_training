package java_Ch04_ClassObject;

public class ArrayParameterTest {
	void runArrayParameter() {
		char c[] = {'T','h','i','s',' ','i','s',' ','a',' ','p','e','n','c','i','l','.'};
		
		ArrayParameter pencil = new ArrayParameter();
		
		pencil.printCharArray(c);
		pencil.replaceSpace(c);
		pencil.printCharArray(c);
	}
}

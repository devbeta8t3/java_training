package DataStructure;

class Ex9_2 {

	public static void main(String[] args) {

		BinaraySearchTree bsT = new BinaraySearchTree();
		
		bsT.insertBST('G');
		bsT.insertBST('I');
		bsT.insertBST('H');
		bsT.insertBST('D');
		bsT.insertBST('B');
		bsT.insertBST('M');
		bsT.insertBST('N');
		bsT.insertBST('A');
		bsT.insertBST('J');
		bsT.insertBST('E');
		bsT.insertBST('Q');
		
		System.out.print("\nBinary Tree >>> ");
		bsT.printBST();
		
		System.out.print("Is There A? >>> ");
		TreeNode p1 = bsT.searchBST('A');
		
		if (p1 != null)
			System.out.println("Searching Success! Searched key : " +p1.data);
		else
			System.out.println("Searching fail!! There is no " +p1.data);
		
		System.out.print("Is There Z? >>> ");
		TreeNode p2 = bsT.searchBST('Z');
		
		if (p2 != null)
			System.out.println("Searching Success! Searched key : " +p2.data);
		else
			System.out.println("Searching fail!! " );
		
	}
}

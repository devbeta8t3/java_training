package DataStructure;

class BinaraySearchTree {

	private TreeNode root = new TreeNode();;
	
	public TreeNode insertKey(TreeNode root, char x) {
		TreeNode p = root;
		TreeNode newNode = new TreeNode();
		
		newNode.data = x;
		newNode.left = null;
		newNode.right = null;
		
		if (p==null)
			return newNode;
		else if (newNode.data < p.data) {		// newNode가 작으면 왼쪽으로 
			p.left = insertKey(p.left, x);		// 재귀
			return p;
		}
		else if (newNode.data > p.data) {		// newNode가 크면 오른쪽으로
			p.right = insertKey(p.right, x);	// 재귀
			return p;
		}
		else
			return p;
	}
	
	public void insertBST(char x) {
		root = insertKey(root, x);
	}
	
	public TreeNode searchBST(char x) {
		TreeNode p = root;
		while (p!=null) {
			if (x < p.data)
				p = p.left;			// p를 p의 왼쪽으로 이동
			else if (x > p.data)
				p = p.right;		// p를 p의 오른쪽으로 이동
			else
				return p;
		}
		return p;
	}
	
	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(" " +root.data);
			inorder(root.right);
		}
	}

	public void printBST() {
		inorder(root);
		System.out.println();
	}
}

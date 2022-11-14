package DataStructure;

class LinkedTree {

	private TreeNode root;
	
	public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2) {
		TreeNode root = new TreeNode();
		root.data = data;
		root.left = bt1;
		root.right = bt2;
		return root;
	}
	
	public void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data);		// 내꺼부터 처리한다.
			preorder(root.left);				// 재귀함수다.
			preorder(root.right);				// 재귀함수다.
		}
	}
	
	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data);
			inorder(root.right);
		}
	}
	
	public void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data);
		}
	}
}

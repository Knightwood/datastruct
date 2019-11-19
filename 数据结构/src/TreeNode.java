public class TreeNode {
	String data;
	TreeNode Parent;
	TreeNode right;
	TreeNode left;
	int height;
	//int level;
	public TreeNode(String data) {
		this.data=data;
		this.left = null;
		this.right=null;
		this.Parent =null;
		this.height=0;
	}
	/*public TreeNode(int data) {
		this.data=data;
		//this.level = level;
	}*/
	public TreeNode(String data,TreeNode parent,TreeNode left, TreeNode right) {
		this.data = data;
		//this.parent=parent;
		this.left = left;
		this.right = right;
		//this.level = level;
	}
	
	
}

//递归版
//注：我这里的单旋转和双旋转的命名左右是与书上反的
public class Avl {
	TreeNode Root=null;
	public Avl() {
		//Root = new TreeNode(data);
	}
	//判断高度
			public int height(TreeNode node) {
				if(node==null) {
					return -1;
				}else
					return node.height;
			}
		//单旋转
			public TreeNode youxuanzhuanl(TreeNode Root) {
				TreeNode temp=null;
				temp = Root.left;
				Root.left=temp.right;//把root的左边弄成空的
				temp.right=Root;
				Root.height=Math.max(height(Root.left), height(Root.right))+1;
				temp.height=Math.max(height(temp.left), height(temp.right))+1;
				return temp;
			}
			public TreeNode zuoxuanzhuanr(TreeNode Root) {
				TreeNode tmp=null;
				tmp = Root.right;
				Root.right=tmp.left;
				tmp.left=Root;
				Root.height=Math.max(height(Root.left), height(Root.right))+1;
				tmp.height=Math.max(height(tmp.left), height(tmp.right))+1;
				return tmp;
			}
	//双旋转
			public TreeNode shuangxuanzhuanlr(TreeNode Root) {
				Root.left = zuoxuanzhuanr(Root.left);
				return youxuanzhuanl(Root);
			}
			public TreeNode shuangxuanzhuanrl(TreeNode Root) {
				Root.right = youxuanzhuanl(Root.right);
				return zuoxuanzhuanr(Root);
			}
	//插入节点
	private TreeNode Insert(TreeNode Root, String data) {
		//判断
		if(Root == null) {
			Root = new TreeNode(data);
		}else if(data.length()<Root.data.length() ) {//判断1
			Root.left= Insert(Root.left, data);
			if(height(Root.left)-height(Root.right)==2) {
				System.out.println("success");
				if(data.length()<Root.left.data.length()){
					Root = youxuanzhuanl(Root);
					System.out.println(Root.right.data);
					
				}else
					Root=shuangxuanzhuanlr(Root);
				}
				
			}
		else if(data.length()>Root.data.length() ){//判断2
			Root.right= Insert(Root.right,data);
			if(height(Root.right)-height(Root.left)==2) {
				if(data.length()>Root.right.data.length()){
					Root=zuoxuanzhuanr(Root);
				}else
					Root=shuangxuanzhuanrl(Root);
				
			}
		}
		Root.height=Math.max(height(Root.left), height(Root.right))+1;
		return Root;
	}
	private TreeNode Delete(TreeNode Root, String data) {
		
		return Root;
	}
	public void insert(String data) {
		Root = Insert(Root, data);
	}
	public void delete(String data) {
		Root = Delete(Root,data);
	}

	
	
	
}

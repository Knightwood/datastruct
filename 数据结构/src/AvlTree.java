//非递归版
public class AvlTree {
	TreeNode Root;

//avl树左右子树高度差绝对值不超过1
	public AvlTree() {
		Root=null;
		//Root.height=0;
	}

	//左旋
	//parent是y  child是x
	public void rr(TreeNode parent) {
		TreeNode child= parent.left;
		parent.left=child.right;
		child.right=parent;
		
		parent.height=Math.max(parent.left.height,parent.right.height);
		child.height=Math.max(child.left.height,child.right.height);
	}
	//右旋
	//parent是x  child是y
	public void lr(TreeNode parent) {
		TreeNode child =parent.right;
		parent.right=child.left;
		child.left=parent;
		
		parent.height=Math.max(parent.left.height,parent.right.height);
		child.height=Math.max(child.left.height,child.right.height);
	}
//添加树节点
/*	public void insert(String data) {
			TreeNode node =new TreeNode(data);
			TreeNode current = Root;
			TreeNode parent = null;
			boolean tag = true;
			TreeNode tmp =find_1(data);
			if(tmp.data==node.data)
				return;
//判断是否是重复节点,tag用来判断节点的左右
			if(Root == null) {
				Root = node;
				Root.left = null;
				Root.right = null;
			return;
			}else {
			while(current!=null) {
				if (data.length()<Root.data.length()) {
				    parent = current;
				    current = current.left;
				    tag = true;}
				if (data.length()>Root.data.length()) {
					parent = current;
					current = current.right;
					tag = false;}
				
			}if(tag==true) {
				//tag等于true说明是节点的左边要插入新的节点
			parent.left =node;
			parent.left.height=0;
			//仅用来初始化高度，后面判断不等于2用，之后节点高度还会重新赋值
			parent.left.Parent=parent;}
			else{
			parent.right= node;
			parent.right.height=0;
			parent.right.Parent=parent;}
//上句在设置父节点，由于current会是null，所以用parent的子节点来确立父节点
			
			}if(tag==true) {
		while(parent.left.height(parent.left)-parent.right.height(parent.right)!=2) {
			current.height=Math.max(current.left.height(current), current.right.height(current))+1;
			parent.height=Math.max(parent.left.height(parent), parent.right.height(parent))+1;
			current=current.Parent;
			parent=parent.Parent;
		}
		System.out.println("没问题");
		//if(data.length()<parent.left.data.length())
			//single();
		//else
			//double();}
			else {
				while(parent.right.height(parent.right)-parent.left.height(parent.left)!=2) {
					current.height=Math.max(current.left.height(current), current.right.height(current))+1;
					parent.height=Math.max(parent.left.height(parent), parent.right.height(parent))+1;
					current=current.Parent;
					parent=parent.Parent;
				}System.out.println("没问题");
				//if(data.length()>parent.left.data.length())
				//	single();
				//else
				//	double();
			}
			
		}
*/		
//删除树节点
		public void DelateNode(String data) {
			TreeNode current = null;
			//current:要删除的节点
			current =find_1(data);
			if(current==Root) {
				current=null;
				return;

			}		
			if(current.left==null&&current.right==null){
				//如果要删除节点（current）的左右都是空
				if(current.Parent.left==current) {
					current.Parent.left=null;
				}else {
					current.Parent.right =null;
				}
			}else if(current.left==null||current.right==null) {
				//如果要删除节点（current）的左右有一个是空
				if(current.left==null&&current.right!=null) {
					current.Parent.right=current.right;
				}else {
					current.Parent.left=current.left;
				}
				
			}else if(current.left!=null&&current.right!=null) {
				//如果要删除节点（current）的左右都不是空
				current.Parent.left=current.left;
				current.left.right = current.right;
			}
		}
//查找
		public TreeNode find_1(String data) {
		//int t=0;之前用作实验方法是否能正常工作，或者能用来计算节点层数什么的
			TreeNode current = Root;
			//TreeNode parent = null;
			while(current!=null) {
				if(data==current.data) {
				//return t;
					return current;
				}
				if (data.length()<current.data.length()) {
				   // parent = current;
				    current = current.left;
				    //++t;
				    }else if (data.length()>current.data.length()) {
					//parent = current;
					current = current.right;
					//++t;
					}
		 }	
			TreeNode node =new TreeNode("不存在");

			return node;
			
		}

}

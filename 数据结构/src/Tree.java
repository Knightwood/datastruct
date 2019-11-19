public class Tree {
	//int hight;
	//int depth = 1;
	TreeNode Root;
	public Tree() {
		//this.depth = 1;
		this.Root=null;
	}
	
//添加树节点
	public void insert(String data) {
		TreeNode node =new TreeNode(data);
		TreeNode current = Root;
		TreeNode parent = null;
		boolean tag = true;
		TreeNode tmp =find_1(data);
		if(tmp.data==node.data)
			return;
		//判断是否是重复节点
		//tag用来判断节点的左右
		if(Root == null) {
			Root = node;
			Root.left = null;
			Root.right = null;
			//System.out.println("google1");
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
		parent.left =node;
		parent.left.Parent=parent;}
		else{
		parent.right= node;
		parent.right.Parent=parent;}
		//上句在设置父节点，由于current会是null，所以用parent的子节点来确立父节点
		}
		
	}
//删除树节点
	public void DelateNode(String data) {
		TreeNode current = null;
		//current:要删除的节点
		current =find_1(data);
		if(current==Root) {
			current=null;
			return;
//根节点也要删除？若是这样置空，那就变成两棵树了。查找也就会出问题。2018.11.21
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
	//int t=0;之前用作实验方法是否能正常工作，
	//或者能用来计算节点层数什么的
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
		//current是要查找的值，但条件是current不为空，所以把这里的return换成异常抛出或者特定的文字或许可以解决无法判断是否是结点的问题2018/11/20
		//return 999;
		//throws new Exception("没有这个值");
	}
	/*
public TreeNode find_2(String data) {
		//中序
	
	if(Root !=null) {
		if(data==Root.data)
			return Root;
		if(data.length()<Root.data) {
			find_2(data,Root.left);
		}else if(data>Root.data)
			find_2(data,Root.right);
	}
		return node;
		
	}
public TreeNode find_3(TreeNode node,TreeNode Root) {
	//后序
	return node;
	
}*/
}

public class SplayTree<T extends Comparable<T>> {
	public SplayNode<T> Root;
	public SplayTree() {
		Root =null;
	}
	
	public class SplayNode<T extends Comparable<T>>{
		T data;
		SplayNode<T> left;
		SplayNode<T> right;
		//SplayNode<T> parent;
		public SplayNode(T data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
		public SplayNode() {
			this.data=null;
			this.left=null;
			this.right=null;
		}
	}
	
	
//旋转方法
	private SplayNode<T> splay(SplayNode<T> Root,T data){
		//SplayNode<T> temp= new SplayNode<T>();
		if(Root==null) {
			return null;
		}
		if(data.compareTo(Root.data)<0) {
			Root.left=splay(Root.left,data);
			Root=rotationRight(Root);
			/*这里的root.left=Root.left=splay(Root.left,data);中的root.left是为了和下面的root区分，因为
			 * 由splay递归执行到符合的新root时，返回的新root其实是上一级root的左孩子。以及，执行下面的旋转后
			 * 返回的root是和上一级的左孩子不一致，所以在这一层要更新。所以需要这个赋值。
			Root=rotationRight(Root);*/
		}else if(data.compareTo(Root.data)>0){
			Root.right=splay(Root.right,data);
			Root=rotationLeft(Root);
		}if(data.compareTo(Root.data)==0) {
			return Root;
			
		}
		
		return Root;
		
	}
	private SplayNode rotationRight(SplayNode<T> node) {
		SplayNode<T> temp;
		temp=node.left;
		node.left=temp.right;
		temp.right=node;
		return temp;
	}
	private SplayNode rotationLeft(SplayNode<T> node) {
		SplayNode<T> temp1;
		temp1=node.right;
		node.right=temp1.left;
		temp1.left=node;
		return temp1;
	}

//插入
	private SplayNode<T> insert(SplayNode<T> Root, T data){
		if(Root==null) {
			Root = new SplayNode<T>(data);
		}else if(data.compareTo(Root.data)<0) {
			Root.left=insert(Root.left,data);
			//Root.left.parent=Root;
			
			
		}
		else if(data.compareTo(Root.data)>0) {
			Root.right = insert(Root.right,data);
			//Root.right.parent=Root;		
			
		}else {
			System.out.println("it was exast");
			return null;
			
		}
		return Root;
	}
	public void Insert(T data){
		Root = insert(Root, data);
		//splay(Root,data);
	}
//查找
	private SplayNode<T> find(SplayNode<T> Root,T data){
			if(data.compareTo(Root.data)==0) {
				return Root;
			}
			else if(data.compareTo(Root.data)<0) {
			find(Root.left, data);
			}
			else if(data.compareTo(Root.data)>0)
			find(Root.right,data);
			
		
		return Root;
			
		
	}
	public SplayNode<T> find(T data){
		if(data==Root.data) {
			return Root;
		}else {
		SplayNode<T> node =find(Root,data);
		Root=splay(Root,data);
		return node;}
	}

}

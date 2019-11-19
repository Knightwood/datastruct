public class Hashtable {
	node[] v=new node[30];
	int capacity=0;
	
	
	class node{
		String key;
		String value;
		node next;
		node(){
			this.key=null;
			this.value=null;
			this.next=null;
		}
		node(String key,String value){
			this.key=key;
			this.value=value;
			this.next=null;
		}
	}
	
	
	
	private void insert_data(node[] a,String key,String value) {
		node node=new node(key,value);
		int hash=hash(key);
		if(v[hash]==null) {
			v[hash]=node;
			
			//前面的数组添加进一个表头，那就容量+1，当存不下的时候，扩容。
			if(++capacity>=0.9*v.length) {
				/*计算是不是快满了，是的话执行扩容*/
				kors(capacity*2);
			}
					}else {
			add(v[hash],node);
			
		}
	}
	void add(node root,node node) {/*这个是在list上添加node*/
		if(root.key!=node.key){//判断是不是有重复key的值，有的话覆盖掉旧的value
		if(root.next==null) {
			root.next=node;
		
		}else {
			add(root.next,node);
		}}else {
			root.value=node.value;
		}
	}
	
	private void kors(int t) {
		node[] tmp=new node[t];
		int j=0;
		for(node i:v) {
			tmp[j++]=i;
			/*把v中的元素赋值给tmp中的位置，
			 * j从零开始自加，直到i从v中遍历完*/
		}
		v=tmp;
	}
	private void delete_data(node[] a,String key,String value) {
		
	}
	private int hash(String key) {
		int hash=0;
		char[] str=key.toCharArray();
		for(char x:str) {
			hash=x+hash;
		}
		hash%=v.length;
		return hash;
	}
	public void insert(String key,String value) {
		insert_data(v,key,value);
	}
	public void delete(String key,String value) {
		delete_data(v,key,value);
	}
	public node find(String key) {
		int h =hash(key);
		node p=v[h];
		while(p.key!=key&&p.next!=null) {
			p=p.next;
		}return p;
	}

}

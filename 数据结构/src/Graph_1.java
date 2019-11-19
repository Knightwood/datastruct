/*用邻接表实现的有向图
 * 这里默认操作都是合法的*/
public class Graph_1 {
	
	node[] head=new node[10];
class node{
	char name;
	node next;
	node edge;
	/*next指此节点能链接到的节点
	 * edge指这个节点.next的节点是哪个头节点
	 * A.next=b b.edge=head[B的位置];b.next=c c.edge=head[C的位置];c.next=d d.edge=head[D的位置]
	 * 这指明a连接到了b,c,d三个节点,b即为B节点。。。。。
	 * */
	node(char str){
		this.name=str;
		this.next=null;
		this.edge=null;
	}
	  }
Graph_1(int n,char[] list) {
	
	int i=0;
	this.head= new node[n];
	for(int j=0;j<head.length;j++) {
		head[j]=new node(list[i]);//初始化数组，并给每个元素的name命名
		i+=1;
		//System.out.println(head[j].name);
	}

}
void add(char a,char b) {
	node b1=new node(b);
	/*for(int x=0;x<head.length;x++) {
		if(head[x].name==a) {
			for(int y=0;y<head.length;y++) {
				if(head[y].name==b) {
					link(head[x],b1);
					b1.edge=head[y];//设置好edge也就是实现b1这个节点就是头节点里相应的那个节点
				}
			}
		}
	}*/
	int x=find(a);
	int y=find(b);
	link(head[x],b1);
	b1.edge=head[y];
}

void widefind() {
	/*先从第一个结点开始，只要这个节点有直接连接的节点，就打印出来，然后转到下一个头节点*/
	int i=0;
	for(;i<head.length;i++) {
		node root=head[i];
		while(root.next != null) {
			System.out.println(head[i].name+ "-->" +root.next.name);
			root=root.next;
		}
	}
}
void delete(char a,char b) {
	/*这个就是把要删除节点的父节点的next设置为这个节点的next值
	 * 例如：A->b->c->d
	 * A.next=A.next.next  就是把A连接到的b删掉*/
	int x=find(a);
	node parent=head[x];
	node current = parent.next;
	while(current!=null && current.name!=b) {
		//这里默认要删除节点都是存在的
		parent=current;
		current=current.next;
	}
	parent.next=current.next;
}

void link(node A,node B) {
	/*设置好头节点连接到的链表*/
	if(A.next==null) {
		A.next=B;
	}else {
		link(A.next,B);
	}
}
int find(char a) {
	/*专门查找特定的头节点*/
	int i=0;
	for(int x=0;x<head.length;x++) {
		if(head[x].name==a)
			i=x;}
			return i;
}

//结束
}

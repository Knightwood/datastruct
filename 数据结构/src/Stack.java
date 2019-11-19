public class Stack  {
	Node first;
	int count;
	int size;
	public Stack() {
		first = null;
		count=0;
		size=0;
	}
	public Stack(int size) {
		first = null;
		count=0;
		this.size= size;
	}
	public void push(String data) {
		Node node =new Node(data);
		Node tmp = new Node(null);
		tmp = first;
		first = node;
		node = tmp;
		first.next= node;
		count++;
		size++;
	}
	public void push1(String data) {
		if(first==null) {
			first=new Node(data);
		}else {
		Node node =new Node(data);
		node.next=first;
		first=node;}
	}
	public Node pop() {
		Node tmp = new Node(null);
		tmp = first.next;
		first = tmp;
		count--;
		size--;
		return first;
	}

}

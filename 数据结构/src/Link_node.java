public class Link_node {
		private Node first;
		private int position = 0;//内部指示位置，注意用完置0；
		private int count=0;//元素数量

		public Link_node() {
			this.first = null;
		}
		public void addFirstNode(String data) {
			Node node = new Node(data);
			//node.next=first;
			first = node;
			count+=1;
			}
		public void delateFirstNode() {
			Node temp = first;
			first =temp.next;
			count-=1;
		}
		public void AddNode(int pos,String data) {
			Node node = new Node(data);
			Node temp = first;
			if(pos>count){
				System.out.println("pos out of limit");
			}else if(pos==count){
				addEndNode(pos,data);
			}
			while((pos-1)!=position) {
				//为了得到要插入位置的前一个对象
				temp = temp.next;
				position++;
			}
			node.next=temp.next;
			temp.next = node;
			position = 0;
			count+=1;
			
		}

	private void addEndNode(int pos, String data) {
			Node tmp=first;
			Node node = new Node(data);
			while (position!=pos-1){
				position++;
				tmp=tmp.next;
			}
			tmp.next=node;
			position=0;
			count+=1;
	}

	public void DelateNode(int pos) {
			Node temp = first;
			Node temp1 = first;
			while(pos!=position) {
				temp = temp1;
				temp1 = temp1.next;
				position++;
			}
			if(position==0) {
				first = first.next ;
			}else {
			temp.next = temp1.next;
			position = 0;}
			count-=1;
		}
		public Node find(int pos) {
			Node temp = first;

			while(pos!=position) {
				temp = temp.next;

				position++;
			}
			position=0;
			
			return temp;
			
		}
}

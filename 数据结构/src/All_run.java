import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class All_run {

	public static void main(String[] args) {

	//链表
		Link_node node1 = new Link_node();
		node1.addFirstNode("a");
		node1.AddNode(1, "g");
		node1.AddNode(2,"c");
		Node node = node1.find(2);
		System.out.println(node.data);
		
		/*
	//栈
		Stack a=new Stack();
		a.push1("a");
		a.push1("b");
		a.push("c");
		System.out.println(a.first.data);
		System.out.println(a.first.next.data);
		System.out.println(a.first.next.next.data);*/
		
		/*
	//树
		Tree k = new Tree();
		 //k.Root =new TreeNode("abc");
		TreeNode tmp =null;
		k.insert("abcd");
		System.out.println(k.Root.data);
		k.insert("ab");
		k.insert("abcdef");
		k.insert("a");
		k.insert("abc");
		tmp=k.Root;
		System.out.println(tmp.left.data);
		k.DelateNode("abcdef");
		TreeNode findnode = null;
		findnode = k.find_1("abcdef");
		System.out.println(findnode.data);*/
		
		/*
//avl树
		AvlTree l =new AvlTree();	
		l.insert("abcdefg");
		l.insert("abcdef");
		l.insert("abcde");
		//l.insert("abcdefg");
		System.out.println(l.Root.data);
		Test123 test = new Test123();
		test.change(test.a);
		System.out.println(test.a.data);

		Avl a = new Avl();
		a.insert("dsafe");
		a.insert("dsafrrrrrrr");
		a.insert("dsa");
		
		System.out.println(a.Root.right.data);*/
		
		
		/*
//splay树
		SplayTree<Integer> splaytree = new SplayTree<Integer>();
		splaytree.Insert(100);
		splaytree.Insert(50);
		splaytree.Insert(25);
		splaytree.find(25);
		System.out.println(splaytree.Root.data);
		Minheap<Integer> heap=new Minheap<Integer>();
		heap.add(10);
		heap.add(0);
		heap.add(5);
		heap.add(1);
		heap.add(6);
		heap.add(9);
		heap.add(3);
		heap.deleteMin();
		for(int i=0;i<heap.size();i++) {
		System.out.println(heap.find(i));}
		//System.out.println(5/2);*/
		
		
		    
		//排序
		int[] a= {75,62,114,156,127,75,52,259,85,179,63,244,96,268,83,275,228,208,284,224,108,180,261,183,151,25,55,288,64,189,268,16,290,3,214,81,143,287,180,228,21,4,70,153,287,45,21,1,244,269,162,17,243,174,282,5,86,170,80,217,62,238,13,71,181,251,138,187,21,97,212,136,290,49,105,196,217,163,91,148,153,201,254,167,132,116,117,177,223,129,214,70,154,88,223,36,155,51,105,248};
		int[] bb= {1,60,3,53,10,100,62,37,8,4,0,66,75,24,7,5,39,44,49,2,9};
		//Sort.selectSort(a,100);
		//Sort.insertSort(a,21);
		Sort.bubbleSort(a,100);
		//Sort.mergeSort(a,100);
		//Sort.quickSort(a,0,99);
		//Sort.shellSort(a,100);
		//Sort.bucketSort(a, a.length, 291);
		
		for(int x:a) {System.out.println(x);}
		
		
		/*
		//hashtable
		Hashtable table=new Hashtable();
		table.insert("one","first");
		table.insert("two","second");
		String s=table.find("one").value;
		System.out.println(s);*/
		
		
		/*
		//graph
		Graph graph=new Graph();
		graph.addedge('C', 'H');
		graph.addedge('A', 'H');
		graph.print('C', 'H');
		graph.find('o', 'H');*/
		
		
		//graph_1
		char[] lis={'A','B','C','D','E','F','G','H','I','J'};
		Graph_1 graph_1=new Graph_1(10,lis);
		graph_1.add('A', 'B');
		graph_1.add('A', 'C');
		graph_1.add('A', 'D');
		graph_1.add('B', 'A');
		graph_1.add('B', 'D');
		graph_1.add('B', 'E');
		graph_1.add('C', 'B');
		graph_1.add('E', 'D');
		graph_1.add('F', 'E');
		graph_1.widefind();
		graph_1.delete('A', 'D');
		System.out.println("==================");
		graph_1.widefind();
	    ArrayList<String> nl = new ArrayList<String>();
		nl.add("one");
		nl.add("two");
	//测试
		
		/*Scanner s =new Scanner(System.in);
		String strt= s.next();
		System.out.println(strt);
		s.close();
		*/
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bb=null;
		while(true) {
			try {
				bb=br.readLine().toString();
				System.out.println(bb);
			}catch(IOException e) {
				e.printStackTrace();
			}
			if(bb.equals("end")) {
				break;
			}
		}
		*/
		
		/*
		int[] tr = {1,2,3,4,5,6,7,8};
		int[] testlist;
		testlist=new int[8];
		int ir=0;
		for(int x=0;x<testlist.length;x++) {
			testlist[x]=tr[ir++];
		}
		for(int ii:testlist) {
			System.out.println(ii);
		}*/
		//foreach里的元素就是一个临时变量，不能拿来用于元素赋值
		
		
		/*
		int ceshi =10;
		int ceshi1=1;
		int ceshi2=1;
		if(ceshi==11 & ++ceshi1>0) {
		
			//因为&不会短路，所以在判断第一个是fals时还会判断第二个表达式，所以这里的ceshi1会变成2
				 
			}else {
				System.out.println(ceshi1);
			}
		if(ceshi==11 && ++ceshi1>0) {
			
			//因为&&会短路，所以在判断第一个是fals时不会再判断第二个表达式，所以这里的ceshi1不变
				 
			}else {
				System.out.println(ceshi2);
			}
		*/
		
		
		//数组测试
		//int[][] uuzu = new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}};
		//System.out.println(uuzu[4][1]);
		
		/*
		try{//异常处理示范
        int as[] = new int[2];
        System.out.println("Access element three :" + as[3]);
     }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Exception thrown  :" + e);
     }
     System.out.println("Out of the block");*/
		
     String splity ="这需要一个/正则表达式，/因此记得在必/要时对/特殊字/符进/行转/义。";
     if(splity.contains("/")) {
    	 String strt[]=new String[0];
    	 strt=splity.split("/");
    	 for(int kjh=0;kjh<strt.length;kjh++) {
    		 System.out.println(strt[kjh]);
    	 }
     }
		
	//结束
	}

}

/*用邻接矩阵（数组）实现的无向图*/
public class Graph {
	char[] vertex=new char[] {'A','B','C','D','E','F','G','H','I','J'};
	int[][] edge = new int[10][10];
	Graph() {
		for(int i=0;i<edge.length;i++) {
			for(int j=0;j<edge[i].length;j++) {
				edge[i][j]=0;
			}
		}
	}
	public int addedge(char first,char second) {
		
		int[] tmp;
		tmp=find(first,second);
			int i=edge[tmp[0]][tmp[1]]=1;
			return i;
	}
	public int[] find(char first,char second) {
		int i=0,j=0;
		int k=vertex.length;
		int[] tmp=new int[]{0,0};
		while(i<k&&vertex[i]!=first) {
			i+=1;
		}
		while(j<k&&vertex[j]!=second) {
			j+=1;
		}
		tmp[0]=i;
		tmp[1]=j;
		try {
			char tmp1=(vertex[i]);
			char tmp2=(vertex[j]);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Exception thrown  :" + e);
			}
			//错误异常处理
		
		return tmp; 
	}
	public void delete(char first,char second) {
		int[] tmp;
		tmp=find(first,second);
			int i=edge[tmp[0]][tmp[1]]=0;
	}
	public void print(char first,char second) {
		int[] tmp=find(first,second);
		System.out.println(edge[tmp[0]][tmp[1]]);
		
	}
}

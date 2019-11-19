import java.util.List;
import java.util.ArrayList;
/*
 * 一个节点是i
 * 左孩子是2i+1
 * 右孩子是2i+2
 * 父节点是(i-1)/2
 */
public class Minheap<T extends Comparable<T>> {
	private List<T> minheap;
	public Minheap() {
		this.minheap=new ArrayList<T>();
		//实例化minheap，minheap其实是一个实例化的arraylist
	}
	
	public T find(int i) {
		return minheap.get(i);
	}
	
	public int size() {
		return minheap.size();
	}
	
	public void add(T data) {
		minheap.add(data);
		int i = minheap.size();
		//System.out.println(i);
		up(i);
	}
	
	private void up(int j) {
		int i=j-1;
		//注意，i是由size得到的，因为位置是从0开始的，所以i比位置多1，
			int p=(i-1)/2;
			T tmp=minheap.get(i);//最后面的元素，也就是最新添加的那个元素
			while(i>0) {//如果list是空的，i=0，那这里条件不符合，直接跳过。
				if(tmp.compareTo(minheap.get(p))<0) {
					minheap.set(i, minheap.get(p));
					i=p;
					p=(p-1)/2;
				}else {
					break;
				}
			}minheap.set(i, tmp);
	}
	
	public void deleteMin() {
		int j =0;
		int i=0;
	//把小的元素覆盖掉父元素，直到最后没有子元素的节点，用最后的节点覆盖掉这个节点。
		while(j<minheap.size()) {
			
			if(minheap.get(j+1).compareTo(minheap.get(j+2))<0) {
				j=j+1;
				if(j>minheap.size()-1)
					j=minheap.size()-1;//确保j不会超出索引，也就是说，确保这个子元素是存在的。j最大就是最后一个元素的位置
			}else {
				j=j+2;
				if(j>minheap.size()-1)
					j=minheap.size()-1;
			}
			
			minheap.set(i, minheap.get(j));
			i=j;
			j*=2;
			/*
			 * 到达没有子元素的叶节点时，j*2是会超出size的。在j*2的基础上+1或+2才是子节点，
			 * 才有可能到达最后的元素
			 * */
		}
		minheap.set(i,minheap.get(minheap.size()-1));
		/*
		 * 上句是一定要有的，因为j最大是最后一个元素，可是好些时候不是，所以，此句一定不能丢
		 * */
		
	}
	


}

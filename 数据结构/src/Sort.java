public class Sort {

	/*选择排序，从第一个开始，把后面小的与之交换。
	n是数组长度，下标范围就是0到n-1*/
	public static void selectSort(int a[],int n) {
		/*
		 * 对于任意一个待排序数组，从第 1 位遍历一次数组，找到最小值，使其与第 1 位交换。
从第二位开始遍历一次数组，找到其中的最小值，使其与第二位进行交换
一般化：从第 i 位遍历一次数组，找到第 i 小的值，使其与第 i 位交换。
最后找到最大值，此时一定在最后一位。不需要进行交换。
最终会是n-2到n-1,
0.1.2.3.4.5.6
n=7,n-1=6,n-2=5
*/
		/*
		 * 在每一趟里把最小的放在前面排好序的里面*/
		int i,j,k;
		
		for(i=0;i<n-1;i++) {
			for(j=i+1;j<n;j++) {
				if(a[i]>a[j]) {
					k=a[i];
					a[i]=a[j];
					a[j]=k;
				}
			}
		}
	}
	
	
	/*
	 * 直接插入排序
	 *
	 * 参数说明：
	 *     a -- 待排序的数组
	 *     n -- 数组的长度
	 */
	public static void insertSort(int a[],int n) {
		/*认为第一位数为一个已经排序好的数组haveSort。// 只有一个数的有序数组。
将第二位数插入到我们逻辑中的数组 haveSort 中去，并保持逻辑数组haveSort有序。
将第三位数插入到我们逻辑中的数组 haveSort 中去，并保持逻辑数组haveSort有序。
..........
将最后一位数插入到我们逻辑中的数组 haveSort 中去，并保持逻辑数组haveSort有序。
此时原数组与我们的逻辑数组haveSort重合，且haveSort有序，所以原数组排序结束。
*/
		int i,j,k;
		for(i=1;i<n;i++) {
			for(j=i;j>0&&a[j]<a[j-1];j--) {
				/*&&:若是第一项就是假，加不会再继续判断第二项
				 * &:不论第一项真假，都要判断第二项*/
				k=a[j-1];
				a[j-1]=a[j];
				a[j]=k;
			}
		}
		
	}
	
	
	
	public static void bubbleSort(int a[],int n) {
		/*
		 * 两两比较，比较n-1趟，每一趟都会把最大的推到后面，
		 * 随着排序的进行，后面是有序的，无序和有序的分界线位置就是 n-i
		 * i代表有几个（最大的值）已经排好序了，所以是从0到n-1。j控制着一次循环中有几次比较*/
		int i,j,k;
		for(i=0;i<n;i++) {
			for(j=1;j<n-i;j++) {
				if(a[j-1]>a[j]) {
					k=a[j];
					a[j]=a[j-1];
					a[j-1]=k;
				}
			}
		}
	}
	
	
	
	public static void shellSort(int[] a,int n) {
		/*
		 * 希尔排序是变种的插入排序，以一个间隔来排序元素，当位置值是n倍（0-N）位置值时，
		 * 会像插入排序一样，把这个位置上的
		 * 值不断地以间隔值为单位，像前插入到合适位置*/
		int i,j;
		int increment = n/2;
		for(;increment>0;increment/=2) {
			for(i=increment;i<n;i++) {
				j=i;
				for(j=i;j>=increment;j-=increment) {
					/*希尔排序也是一种插入排序，在间隔为increment的两边比较大小执行交换，而且
					 * 遇到小的元素，会一直向前移动，直到位置i减去间隔不大于0，也就是位置i小于间隔
					 * 例如：12个元素，在间隔等于3的时候，i自加到了10，遇到小的元素，那会7位置与10位置元素互换
					 * 7位置与4位置元素互换，1位置与4位置元素互换*/
					if(a[j]<a[j-increment]) {
						swap(a,j,j-increment);
					}
				}
			}
		}
	}
	
	
	
	public static void quickSort(int a[],int left,int right) {
		/*数组长度大于3，用快排比较好
		 *pivot:基准
		 *right是n-1 */
		
		int cutoff=3;
		int pivot;
		if(left+cutoff<right) {
		pivot=median3(a,left,right);
		swap(a,pivot,right);//把枢纽放到最后
		int j=right-1;
		int i=left;
		for(;;) {
			/*a[right]是枢纽，如果左边和右边的元素一个小于枢纽，一个大于枢纽，那什么也不做
			* 两个while停止的时候要么是左边和右边位置排查到了中间，也就是左边都是小于枢纽，右边都是大于枢纽的
			* 要么就是左边一个元素和右边一个元素相对枢纽来说，应该交换了，也就是左边的元素大于枢纽，第一个while停止，
			* 第二个while遇到小于枢纽，这时也停止了，接下来就该执行交换大小。*/
			while(a[++i]<a[right]){};
			while(a[--j]>a[right]){};
			if(i<j) {
			swap(a,i,j);
			}else {
				break;
			}
		}
		swap(a,i,right-1);//把枢纽元放回中间
		quickSort(a,left,pivot);//左边再一次进行快排
		quickSort(a,pivot+1,right);//右边再一次进行快排
		}else {
			insertSort(a,right+1);//数组过短，直接进行插入排序
		}
		
	}
	static int median3(int[] a,int start,int end) {
		int pos=(start+end)/2;
		if(a[start]>a[pos]) {
			swap(a,start,pos);
		}
		if(a[start]>a[end]) {
			swap(a,start,end);
		}
		if(a[pos]>a[end]) {
			swap(a,pos,end);
		}
		return pos;
	}
	static void swap(int[] a,int pos1,int pos2) {
		int tmp=a[pos1];
		a[pos1]=a[pos2];
		a[pos2]=tmp;
	}
	
	
	
	public static void mergeSort(int[] a,int n) {
		if(a==null) {
			return;
		}else {
			int[] tmparray = new int[n];
			merge(a,tmparray,0,n-1);
		}
	}
	static void merge(int[] a,int[] tmparray,int start,int end) {
		/*数组递归的被分成两部分，都会执行sort进行排序，直到分成单个元素终止排序操作*/
		if(start<end) {
		int center = (start+end)/2;
		merge(a,tmparray,start,center);
		merge(a,tmparray,center+1,end);
		sort(a,tmparray,start,center,center+1,end);}
	}
	static void sort(int[] a,int[] tmparray,int lpos,int lend,int cpos,int rend) {
		/*int lpos,就是一个数组的最左边的元素，也是上面的start
		 * int lend,就是中间值center
		 * int cpos,就是center+1
		 * int rend就是数组的最后值，就是数组长度-1
		 * int[] tmparray,存放排好顺序的元素的数组
		 * int j,j代表在tmparray中的位置，不一定从0开始，所以要被lpos赋值
		 * int num,代表元素的数量
		 * */
		int j=lpos;
		int num=rend-lpos+1;
		while(lpos<=lend&&cpos<=rend) {
			/*这里就是左边和右边依次，
			 * 每个元素进行比较：
			 * 		左1和右1比较，小的放进tmparray。
			 * 		左2和右2进行比较，小的放进tmparray
			 * 这样进行*/
			if(a[lpos]<=a[cpos]) {
				tmparray[j++]=a[lpos++];
			}else {
				tmparray[j++]=a[cpos++];
			}
		}
		while(lpos<=lend){
			/*
			 * 若是上面又一边空了，那就是说，另一边的排序是正确的，直接在这里的循环里复制进tmparray
			 */
			tmparray[j++]=a[lpos++];
			
		}
		while(cpos<=rend) {
			tmparray[j++]=a[cpos++];
		}
		for(int i=0;i<num;i++,rend--) {
			/*
			 * 把tmparray里的数据复制回a*/
			a[rend]=tmparray[rend];
		}
	}
	
	
	static void bucketSort(int[] a,int n, int max) {
		/*原理是用待排序的数组中以最大值创建一个最大值长度的新的数组，初始化为0，
		 * 然后遍历待排序数组，以当前数值作为新数组的下标值，在那个位置加1.*/
		int[] b=new int[max];
		for(int i=0;i<n;i++) {
			int t=a[i];
			b[t]++;
		}
		
		for(int x=0;x<b.length;x++) {
			//x是下标，也是待排序数组中元素的值，若是打印，应该打印下，b[x]的数值减到0，然后是下一个数值；
			if(b[x]!=0) {
				int j=b[x];
				while(j!=0) {
				--j;
				System.out.println(x);}
			}
		}
	}
	
	
	
	
//结束	
}

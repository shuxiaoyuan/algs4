package sort;

public abstract class MergeSort extends Sort {

	protected static Comparable[] aux; // 归并所需的辅助数组

	// 将 a[lo..mid] 和 a[mid+1..hi] 归并
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		// 保存两个数组的最低位置下标
		int i = lo, j = mid + 1;
		
		// 给辅助数组赋值
		for(int k = lo; k <= hi; k++) aux[k] = a[k];

		// 归并回 a[lo..hi]
		for(int k = lo; k <= hi; k++) {
			if(i > mid)       		      a[k] = aux[j++];
			else if(j > hi) 		  	  a[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			else 					  	  a[k] = aux[i++];
		}
		
	}
	
}

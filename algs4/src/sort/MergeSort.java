package sort;

public abstract class MergeSort extends Sort {

	protected static Comparable[] aux; // �鲢����ĸ�������

	// �� a[lo..mid] �� a[mid+1..hi] �鲢
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		// ����������������λ���±�
		int i = lo, j = mid + 1;
		
		// ���������鸳ֵ
		for(int k = lo; k <= hi; k++) aux[k] = a[k];

		// �鲢�� a[lo..hi]
		for(int k = lo; k <= hi; k++) {
			if(i > mid)       		      a[k] = aux[j++];
			else if(j > hi) 		  	  a[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			else 					  	  a[k] = aux[i++];
		}
		
	}
	
}

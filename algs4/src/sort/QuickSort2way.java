package sort;

public class QuickSort2way extends QuickSort {

	@Override
	public void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	// �������Ϊ a[lo..i - 1], a[i], a[i + 1..hi] 
	public static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while(true) {
			// ɨ�����ң�����Ƿ����������Ԫ��
			while(less(a[++i], v)) if(i == hi) break;
			while(less(v, a[--j])) if(j == lo) break;
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j; 
	}
	
}

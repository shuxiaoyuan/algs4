package sort;

public class MergeSortTD extends MergeSort {

	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	
	// 自顶向下的分治法思想
	public void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		if(hi <= lo) return;
		int mid = (lo + hi) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

}

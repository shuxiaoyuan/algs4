package sorting;

public class MergeSortBU extends MergeSort {

	// 自底向上的思想
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int N = a.length;
		aux = new Comparable[N];
		
		// 先是一个一个地归并，然后再两个两个地归并，然后四个...
		for(int sz = 1; sz < N; sz = sz + sz) {
			// lo 为每组最左边的元素的下标
			for(int lo = 0; lo < N - sz; lo += sz + sz) {
				merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
			}
		}
		
	}

}

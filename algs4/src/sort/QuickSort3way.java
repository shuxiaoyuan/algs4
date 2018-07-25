package sort;

public class QuickSort3way extends QuickSort {

	@Override
	public void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		if(hi <= lo) return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		while(i <= gt) {
			int cmp = a[i].compareTo(v);
			if(cmp < 0) exch(a, lt++, i++);
			else if(cmp > 0) exch(a, i, gt--);
		}
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}

}

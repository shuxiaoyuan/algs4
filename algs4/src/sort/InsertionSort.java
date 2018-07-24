package sort;

public class InsertionSort extends Sort {

	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		for(int i = 1; i < a.length; i++) {
			for(int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j - 1, j);
			}
		}
	}

}

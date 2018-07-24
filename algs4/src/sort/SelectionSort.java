package sort;

public class SelectionSort extends Sort {

	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		for(int i = 0; i < a.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < a.length; j++) {
				if(less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}

}

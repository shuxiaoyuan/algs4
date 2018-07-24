package sort;

public class BubbleSort extends Sort {

	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		for(int i = 0; i < a.length - 1; i++) {
			for(int j = 0; j < a.length - 1 - i; j++) {
				if(less(a[j + 1], a[j])) {
					exch(a, j, j + 1);
				}
			}
		}
	}

}

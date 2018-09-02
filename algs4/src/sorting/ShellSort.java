package sorting;

public class ShellSort extends Sort {

	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int N = a.length;
		int h = 1;
		while(h < N/3) {
			h = 3 * h + 1; // 1,4,13,40...
		}
		
		while(h >=1) {
			for(int i = h; i < a.length; i++) {
				for(int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h /= 3;
		}
		
	}

}

package sorting;

public class HeapSort extends Sort {
	
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
	    
	    // 最后一个有子结点的结点下标
	    int lastK = (a.length - 2) / 2;
	    // 建堆
	    for(int i = lastK; i >= 0; i--)
	        sink(a, i, a.length - 1);
	    // 排序
	    for(int i = a.length - 1; i > 0; i--) {
	        exch(a, 0, i);
	        sink(a, 0, i-1);
	    }
	}

	private void sink(Comparable[] a, int k, int n) {
	    while(2 * k + 1 <= n) {
	        int j = 2 * k + 1;
	        if(j < n && less(a[j], a[j+1])) j++;
	        if(!less(a[k], a[j])) break;
	        exch(a, k, j);
	        k = j;
	    }
	}

}

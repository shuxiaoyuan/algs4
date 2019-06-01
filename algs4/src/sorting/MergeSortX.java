package sorting;

public class MergeSortX extends Sort {

    private static final int CUTOFF = 7;
    
    @Override
    public void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sortTD(aux, a, 0, a.length-1);
    }
    
    private void sortTD(Comparable[] src, Comparable[] dst, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        if(hi <= lo+CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }
        int mid = lo + (hi-lo)/2;
        sortTD(dst, src, lo, mid);
        sortTD(dst, src, mid+1, hi);
        
//        if(!less(src[mid+1], src[mid])) {
//            for(int i = lo; i <= hi; ++i) {
//                dst[i] = src[i];
//                return;
//            }
//        }
        
        // 用 System.arraycopy() 比上面注释的方法快一点
        if(!less(src[mid+1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi-lo+1);
            return;
        }
        
        merge(src, dst, lo, mid, hi);
    }

    private void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; ++k) {
            if(i > mid) {
                dst[k] = src[j++];
            }
            else if(j > hi) {
                dst[k] = src[i++];
            }
            else if(less(src[j], src[i])) {
                dst[k] = src[j++];
            }
            else {
                dst[k] = src[i++];
            }
        }
    }
    
    private void insertionSort(Comparable[] a, int lo, int hi) {
        for(int i = lo + 1; i <= hi; ++i) {
            Comparable tmp = a[i];
            int j;
            for(j = i; j > lo && (less(tmp, a[j-1])); --j) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }
    
}

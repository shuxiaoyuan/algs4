package sorting;

/**
 * Author: Sean Lee
 * Date&Time: 2019年6月5日 下午2:42:58
 * Description: P206 算法2.7 堆排序
*/
public class HeapSort extends Sort {

    @Override
    protected void sort(Comparable[] a) {
        int N = a.length;
        for(int k = N/2 - 1; k >= 0; --k) {
            sink(a, k, N);
        }
        while(N > 1) {
            exch(a, 0, N-1);
            --N;
            sink(a, 0, N);
        }
    }
    
    private void sink(Comparable[] a, int k, int N) {
        while(2*k + 1 < N) {
            int j = 2*k + 1;
            if(j+1 < N && less(a[j], a[j+1])) ++j;
            if(!less(a[k], a[j])) break;
            exch(a, k, j);
            k = j;
        }
    }

}

package sorting;

/**
 * Author: Sean Lee
 * Date&Time: 2019年6月2日 下午2:22:34
 * Description: P171 算法 2.4 自顶向下的归并排序 & P175 自底向上的归并排序
*/
public class MergeSort extends Sort {

    private Comparable[] aux;   // 归并所需的辅助数组
    
    @Override
    protected void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // 一次性分配空间
//        sortTD(a, 0, a.length-1);
        sortBU(a);
    }
    
    private void sortTD(Comparable[] a, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        int mid = lo + (hi-lo)/2;
        sortTD(a, lo, mid);     // 将左半边排序
        sortTD(a, mid+1, hi);   // 将右半边排序
        merge(a, lo, mid, hi);  // 归并结果
    }
    
    private void sortBU(Comparable[] a) {
        // 进行 lgN 次两两归并
        int N = a.length;
        for(int sz = 1; sz < N; sz += sz) {             // sz 子数组大小
            for(int lo = 0; lo < N-sz; lo += sz+sz) {   // lo:子数组索引
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }
    
    private void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将 a[lo..mid] 和 a[mid+1..hi] 归并
        int i = lo, j = mid + 1;
        
        // 将 a[lo..hi] 复制到 aux[lo..hi]
        for(int k = lo; k <= hi; ++k) {
            aux[k] = a[k];
        }
        
        // 归并回 a[lo..hi]
        for(int k = lo; k <= hi; ++k) {
            if(i > mid) {
                a[k] = aux[j++];
            }
            else if(j > hi) {
                a[k] = aux[i++];
            }
            else if(less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }
    }

}

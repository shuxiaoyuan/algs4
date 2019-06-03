package sorting;

/**
 * Author: Sean Lee
 * Date&Time: 2019年6月3日 下午4:41:18
 * Description: P189 三向切分的快速排序
*/
public class Quick3waySort extends Sort {

    @Override
    protected void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if(lo >= hi) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt) {
            int cmp = a[i].compareTo(v);
            if(cmp < 0) exch(a, lt++, i++);
            else if(cmp > 0) exch(a, gt--, i);
            else ++i;
        }   // 现在 a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi] 成立
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
    
}

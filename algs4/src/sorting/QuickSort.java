package sorting;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Author: Sean Lee
 * Date&Time: 2019年6月3日 下午3:46:05
 * Description: P182 算法2.5 快速排序
*/
public class QuickSort extends Sort {

    @Override
    protected void sort(Comparable[] a) {
        StdRandom.shuffle(a);   // 消除对输入的依赖
        sort(a, 0, a.length-1);
    }
    
    private void sort(Comparable[] a, int lo, int hi) {
        if(lo >= hi) return;
        int j = partition(a, lo, hi);   // 切分
        sort(a, lo, j-1);               // 将左半部分 a[lo..j-1] 排序
        sort(a, j+1, hi);               // 将右半部分 a[j+1..hi] 排序
    }
    
    private int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为 a[lo..i-1], a[i], a[i+1..hi]
        int i = lo, j = hi + 1;     // 左右扫描指针
        Comparable v = a[lo];       // 切分元素
        while(true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while(less(a[++i], v)) if(i == hi) break;
            while(less(v, a[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);     // 将 v = a[j] 放入正确的位置
        return j;           // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
    }

}

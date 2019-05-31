package sorting;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月31日 下午3:14:13
 * Description: P163 算法2.3 希尔排序
*/
public class ShellSort extends Sort {

    @Override
    protected void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while(h < N/3) {
            h = 3*h + 1;  // 1, 4, 13, 40, 121, 364, 1093, ...
        }
        while(h >= 1) {
            for(int i = h; i < N; ++i) {
                for(int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }

}

package sorting;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月26日 下午3:09:51
 * Description: 冒泡排序
*/
public class BubbleSort extends Sort {

    @Override
    protected void sort(Comparable[] a) {
        int N = a.length;
        boolean isSorted;   // 若冒泡过程中已经排好序，则没必要继续冒泡
        for(int i = 1; i < N; ++i) {
            isSorted = true;
            for(int j = 0; j < N - i; ++j) {
                if(less(a[j+1], a[j])) {
                    exch(a, j, j+1);
                    isSorted = false;
                }
            }
            if(isSorted) {
                return;
            }
        }
    }

}

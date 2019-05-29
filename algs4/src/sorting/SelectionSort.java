package sorting;


/**
 * Author: Sean Lee
 * Date&Time: 2019年5月26日 下午3:01:32
 * Description: P156 算法2.1 选择排序
*/
public class SelectionSort extends Sort {

    @Override
    public void sort(Comparable[] a) {
        // 将 a[] 按升序排列
        int N = a.length;
        for(int i = 0; i < N; ++i) {
            int min = i;
            for(int j = i + 1; j < N; ++j) {
                if(less(a[j], min)) {
                    min = j;    // 只是记下下标，没有立即交换，防止多次交换的消耗
                }
            }
            exch(a, i, min);
        }
    }

}

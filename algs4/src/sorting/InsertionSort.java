package sorting;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月29日 上午9:22:22
 * Description: P157 算法2.2 插入排序
*/
public class InsertionSort extends Sort {

    @Override
    protected void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 1; i < N; ++i) {
            Comparable tmp = a[i];
            int j;
            for(j = i; j > 0 && less(tmp, a[j-1]); --j) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    public void sortWithExch(Comparable[] a) {
        int N = a.length;
        for(int i = 1; i < N; ++i) {
            for(int j = i; j > 0 && less(a[j], a[j-1]); --j) {
                exch(a, j, j-1);
            }
        }
    }
    
}

package sorting;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月26日 上午9:54:53
 * Description: P153 排序算法类的模板
*/
public abstract class Sort {

    abstract public void sort(Comparable[] a);
    
    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    protected void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    protected void show(Comparable[] a) {
        for(int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
    }
    
    protected boolean isSorted(Comparable[] a) {
        // 采用遍历法测试数组是否有序
        for(int i = 1; i < a.length; ++i) {
            if(less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

}

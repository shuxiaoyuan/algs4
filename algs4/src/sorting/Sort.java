package sorting;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月26日 上午9:54:53
 * Description: P153 排序算法类的模板
*/
public abstract class Sort {
    
    abstract protected void sort(Comparable[] a);
    
    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    protected void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    public void sortWithCopyShow(Comparable[] a) {
        Comparable[] b = a.clone();    // 拷贝到新的数组，不影响原来数组顺序
        Stopwatch stopwatchA = new Stopwatch();
        sort(b);
        double time = stopwatchA.elapsedTime();
        System.out.println(getClass().getSimpleName() + ":");
        System.out.println("    time: " + time + "s, sorted: " + isSorted(b));
    }
    
    private boolean isSorted(Comparable[] a) {
        // 采用遍历法测试数组是否有序
        for(int i = 1; i < a.length; ++i) {
            if(less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

}

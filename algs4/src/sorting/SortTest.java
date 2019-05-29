package sorting;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月27日 下午7:25:14
 * Description: 排序测试类
*/
public class SortTest {

    public static void main(String[] args) {
        int N = 20_000;
        Integer a[] = new Integer[N];
        Integer b[] = new Integer[N];
        for(int i = 0; i < N; ++i) {
            a[i] = (int)(StdRandom.uniform() * N);
            b[i] = a[i];
        }
        
        Sort sort = new InsertionSort();
        
        Stopwatch stopwatchA = new Stopwatch();
        sort.sort(a);
        System.out.println("time: " + stopwatchA.elapsedTime() + "s");
        System.out.println("is a sorted: " + sort.isSorted(a));
        
        Stopwatch stopwatchB = new Stopwatch();
        ((InsertionSort)sort).sortWithExch(b);
        System.out.println("time: " + stopwatchB.elapsedTime() + "s");
        System.out.println("is b sorted: " + sort.isSorted(b));
    }

}

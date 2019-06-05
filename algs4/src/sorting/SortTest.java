package sorting;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月27日 下午7:25:14
 * Description: 排序测试类
*/
public class SortTest {

    public static void main(String[] args) {
        int N = 30_000;
        Integer a[] = new Integer[N];
        for(int i = 0; i < N; ++i) {
            a[i] = (int)(StdRandom.uniform() * N);
        }
        
        Sort bubbleSort = new BubbleSort();
        Sort selectionSort = new SelectionSort();
        Sort insertionSort = new InsertionSort();
        Sort shellSort = new ShellSort();
        Sort mergeSort = new MergeSort();
        Sort mergeSortX = new MergeSortX();
        Sort quickSort = new QuickSort();
        Sort quick3waySort = new Quick3waySort();
        Sort heapSort = new HeapSort();
        
        bubbleSort.sortWithCopyShow(a);
        selectionSort.sortWithCopyShow(a);
        insertionSort.sortWithCopyShow(a);
        shellSort.sortWithCopyShow(a);
        mergeSort.sortWithCopyShow(a);
        mergeSortX.sortWithCopyShow(a);
        quickSort.sortWithCopyShow(a);
        quick3waySort.sortWithCopyShow(a);
        heapSort.sortWithCopyShow(a);
    }

}

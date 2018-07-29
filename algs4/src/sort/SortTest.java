package sort;

public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] a = {6,3,8,2,9,1};
		
		//Sort sort = new BubbleSort();
		//Sort sort = new BubbleSortX();
		//Sort sort = new SelectionSort();
		//Sort sort = new InsertionSort();
		//Sort sort = new InsertionSortX();
		//Sort sort = new ShellSort();
		//Sort sort = new MergeSortTD();
		//Sort sort = new QuickSort2way();
		Sort sort = new QuickSort3way();
		//Sort sort = new HeapSort();
		
		sort.sort(a);
		sort.show(a);
	}

}

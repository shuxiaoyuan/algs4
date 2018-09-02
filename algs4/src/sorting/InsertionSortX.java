package sorting;

public class InsertionSortX extends Sort {
	
	// algs4 网站上的版本加了一个有序检测以及把最小值放在第一个位置
	//不过用 SortCompare 测试得到的结果是不如自己写的这个版本快
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		for(int i = 1; i < a.length; i++) {
			int j = i;
			Comparable k = a[j];
			while(j > 0 && less(k, a[j - 1])) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = k;
		}
	}

}

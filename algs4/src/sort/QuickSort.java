package sort;

import edu.princeton.cs.algs4.StdRandom;

public abstract class QuickSort extends Sort {

	public abstract void sort(Comparable[] a, int lo, int hi);
	
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		StdRandom.shuffle(a); // 消除对输入的依赖
		sort(a, 0, a.length - 1);
	}

}

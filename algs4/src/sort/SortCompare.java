package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

	public static double time(String alg, Comparable[] a) {
		Stopwatch timer = new Stopwatch();
		if(alg.equals("Bubble"))     new BubbleSort().sort(a);
		if(alg.equals("Selection"))  new SelectionSort().sort(a);
		if(alg.equals("Insertion"))  new InsertionSort().sort(a);
		if(alg.equals("InsertionX")) new InsertionSortX().sort(a);
		if(alg.equals("Shell"))      new ShellSort().sort(a);
		if(alg.equals("MergeTD"))    new MergeSortTD().sort(a);
		if(alg.equals("MergeBU"))    new MergeSortBU().sort(a);
		
		return timer.elapsedTime();
	}
	
	// 使用算法 alg 将 T 个长度为 N 的数组排序
	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		
		for(int t = 0; t < T; t++) {
			// 进行一次测试（生成一个数组并排序）
			for(int i = 0; i < N; i++) {
				a[i] = StdRandom.uniform();
			}
			total += time(alg, a);
		}
		return total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		StdOut.printf("For %d random Doubles\n	%s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
	}

}

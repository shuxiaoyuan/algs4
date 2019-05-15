package fundamentals;

import java.util.HashSet;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class NSumTest {

	/**
	 * 随机生成一个长度为 len、每个整数各不相同的数组
	 * @param len
	 * @return array
	 * @throws IllegalArgumentException if len >= 21,474,836
	 */
	private static int[] getRandomDiverseArray(int len) {
		if(len >= Integer.MAX_VALUE / 100) {
			throw new IllegalArgumentException("len must be min than 21,474,836 !");
		};
		int[] a = new int[len];
		HashSet<Integer> hashSet = new HashSet<>(len);
		while(hashSet.size() < len) {
			hashSet.add(StdRandom.uniform(-len * 10, len * 10));	
		}
		int i = 0;
		for(int n : hashSet) {
			a[i++] = n;
		}
		return a;
	}
	
	public static void main(String[] args) {
		
		// 选择要创建的实例
		NSum nSum = new TwoSum();
//		NSum nSum = new ThreeSum();
		
		// 生成数组
		int[] a = getRandomDiverseArray(10_000);
		
		// 对暴力法计时
		Stopwatch timerBruteForce = new Stopwatch();
		int countBruteForce = nSum.bruteForce(a);
		System.out.println("countBruteForce: " + countBruteForce + ", timeBruteForce: " + timerBruteForce.elapsedTime() + "s");
		
		// 对排序+二分法计时
		Stopwatch timerSortSearch = new Stopwatch();
		int countSortSearch = nSum.sortSearch(a);
		System.out.println("countSortSearch: " + countSortSearch + ", timesortSearch: " + timerSortSearch.elapsedTime() + "s");
		
	}
}

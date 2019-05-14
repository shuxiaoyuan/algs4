package fundamentals;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月14日 下午2:52:27
 * Description: P119 2-sum 问题
*/
public class TwoSum {
	
	/**
	 * 暴力，时间复杂度 N^2
	 * @param a
	 * @return
	 */
	private static int bruteForce(int[] a) {
		int len = a.length;
		int count = 0;
		for(int i = 0; i < len; ++i) {
			for(int j = i + 1; j < len; ++j) {
				if(a[i] + a[j] == 0) {
					++count;
				}
			}
		}
		return count;
	}

	
	/**
	 * 先归并排序，再遍历进行二分查找，时间复杂度为 NlogN
	 * 注意此方法会破坏原数组的元素顺序
	 * @param a
	 * @return
	 */
	public static int sortSearch(int[] a) {
		Arrays.sort(a);		// 归并排序，时间复杂度 NlogN
		int len = a.length;
		int count = 0;
		for(int i = 0; i < len; ++i) {
			if(BinarySearch.indexOf(a,-a[i]) > i) {
				++count;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		// 随机生成一个长度为 len 的数组
		int len = 100_000;
		int[] a = new int[len];
		for(int i = 0; i < len; ++i) {
			a[i] = StdRandom.uniform(-len, len);
		}
		
		// 对暴力法计时
		Stopwatch timerBruteForce = new Stopwatch();
		bruteForce(a);
		System.out.println("bruteForce: " + timerBruteForce.elapsedTime() + "s");
		
		// 对排序+二分法计时
		Stopwatch timerBinarySearch = new Stopwatch();
		sortSearch(a);
		System.out.println("binarySearch: " + timerBinarySearch.elapsedTime() + "s");
		
	}

}

package fundamentals;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月14日 下午2:52:27
 * Description: P119 2-sum 问题
*/
public class TwoSum extends NSum {
	
	@Override
	public int bruteForce(int[] a) {
		// 时间复杂度： N^2
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
	
	@Override
	public int sortSearch(int[] a) {
		// 时间复杂度： NlogN
		Arrays.sort(a);		// 归并排序，时间复杂度 NlogN
		int len = a.length;
		int count = 0;
		for(int i = 0; i < len; ++i) {
			if(BinarySearch.indexOf(a, -a[i]) > i) {
				++count;
			}
		}
		return count;
	}
	
}

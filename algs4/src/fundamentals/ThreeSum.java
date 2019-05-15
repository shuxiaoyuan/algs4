package fundamentals;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月15日 上午8:12:39
 * Description: P120 3-sum 问题
*/
public class ThreeSum extends NSum {

	@Override
	public int bruteForce(int[] a) {
		// 时间复杂度： N^3
		int len = a.length;
		int count = 0;
		for(int i = 0; i < len; ++i) {
			for(int j = i + 1; j < len; ++j) {
				for(int k = j + 1; k < len; ++k) {
					if(a[i] + a[j] + a[k] == 0) {
						++count;
					}
				}
			}
		}
		return count;
	}
	
	@Override
	public int sortSearch(int[] a) {
		// 时间复杂度： N^2logN
		int len = a.length;
		int count = 0;
		Arrays.sort(a);
		for(int i = 0; i < len; ++i) {
			for(int j = i + 1; j < len; ++j) {
				if(BinarySearch.indexOf(a, -(a[i] + a[j])) > j) {
					++count;
				}
			}
		}
		return count;
	}
	
}

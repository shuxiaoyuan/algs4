package fundamentals;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月15日 上午8:52:48
 * Description: 根据 TwoSum 和 ThreeSum 抽象出来的 NSum 基类
*/
public abstract class NSum {

	/**
	 * 暴力
	 */
	abstract public int bruteForce(int[] a);
	
	/**
	 * 先归并排序，再遍历进行二分查找
	 * 注意此方法会破坏原数组的元素顺序
	 */
	abstract public int sortSearch(int[] a);
	
}

package fundamentals;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月19日 上午9:36:02
 * Description: P138 算法 1.5 union-find 的实现
*/
public abstract class UF {

	protected int[] id;    // 分量 id（以触点作为索引）
	protected int count;   // 分量数量
	
	public UF(int N) {
		// 初始化分量 id 数组
		count = N;
		id = new int[N];
		for(int i = 0; i < N; ++i) {
			id[i] = i;
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	abstract public int find(int p);
	
	abstract public void union(int p, int q);

}

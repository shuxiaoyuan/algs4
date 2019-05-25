package fundamentals;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月19日 上午9:35:42
 * Description: P140 quick-find 算法
*/
public class QuickFind extends UF {

	public QuickFind(int N) {
		super(N);
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	@Override
	public void union(int p, int q) {
	    // 将 p 和 q 归并到相同的分量中
	    int pID = find(p);
	    int qID = find(q);
	    
	    // 如果 p 和 q 已经在相同的分量之中则不需要采取任何行动
	    if(pID == qID) {
	        return;
	    }
	    
	    // 将 p 的分量重命名为 q 的名称
	    for(int i = 0; i < id.length; ++i) {
	        if(id[i] == pID) {
	            id[i] = qID;
	        }
	    }
	    
	    --count;
	}
}

package fundamentals;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月19日 下午2:51:05
 * Description: P145 算法 1.5（续）union-find 算法的实现（加权 quick-union 算法）
*/
public class WeightedQuickUnionUF extends UF {

    private int[] sz;   // （由触点索引的）各个根节点所对应的分量的大小
    
    public WeightedQuickUnionUF(int N) {
        super(N);
        sz = new int[N];
        for(int i = 0; i < N; ++i) {
            sz[i] = 1;
        }
    }

    @Override
    public int find(int p) {
        // 跟随链接找到根节点
        while(p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) {
            return;
        }
        
        // 将小树的根节点连接到大树的根节点
        if(sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        --count;
    }

}

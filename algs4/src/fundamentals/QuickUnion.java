package fundamentals;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月19日 下午2:22:35
 * Description: P141 quick-union 算法
*/
public class QuickUnion extends UF {

    public QuickUnion(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        // 找出分量的名称
        while(p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        // 将 p 和 q 的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        --count;
    }

}

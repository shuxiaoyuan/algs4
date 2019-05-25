package fundamentals;

/**
 * Author: Sean Lee
 * Date&Time: 2019年5月19日 下午4:44:13
 * Description: P147 最优算法（使用路径压缩的加权 quick-union 算法）
*/
public class WeightedQuickUnionPathCompressionUF extends WeightedQuickUnionUF {

    public WeightedQuickUnionPathCompressionUF(int N) {
        super(N);
    }
    
    @Override
    public int find(int p) {
        int root = p;
        while(root != id[root]) {
            root = id[root];
        }
        
        // 路径压缩
        while(p != root) {
            int tmp = id[p];
            id[p] = root;
            p = tmp;
        }
        
        return root;
    }

}

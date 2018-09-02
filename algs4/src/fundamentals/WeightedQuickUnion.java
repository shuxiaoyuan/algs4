package fundamentals;

public class WeightedQuickUnion {
    private int[] id;
    private int count;
    private int[] sz;
    
    public WeightedQuickUnion(int N) {
        id = new int[N];
        count = N;
        sz = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    
    public int find(int p) {
        int root = p;
        while(root != id[root]) {
            root = id[root];
        }
        // 下面进行路径压缩
        while(p != root) {
            int newp = id[p];
            id[newp] = root;
            p = newp;
        }
        return root;
    }
    
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) {
            return;
        }
        if(sz[pRoot] > sz[qRoot]) {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        else {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        count--;
    }
    
}

package fundamentals;

public class QuickUnion {
    private int[] id;
    private int count;
    
    public QuickUnion(int N) {
        id = new int[N];
        count = N;
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    
    public int find(int p) {
        // 根结点 root == id[root]
        while(p != id[p]) {
            p = id[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;  // 根 pID 指向 qID
        count--;
    }
    
}

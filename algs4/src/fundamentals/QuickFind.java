package fundamentals;

public class QuickFind {
    private int[] id;   // 分量 id （以触点作为索引）
    private int count;  // 分量数量
    
    public QuickFind(int N) {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    
    public int count() {
        return count;
    }
    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    public int find(int p) {
        return id[p];
    }
    
    public void union(int p, int q) {
        // 将 p 和 q 归并到相同的分量中
        int pID = find(p);
        int qID = find(q);
        
        // 如果 p 和 q 已经在相同的分量之中则不需要采取任何行动
        if(pID == qID) {
            return;
        }
        for(int i = 0; i < id.length; i++) {
            if(id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }
    
}

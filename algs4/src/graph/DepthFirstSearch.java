package graph;

public class DepthFirstSearch {
    private boolean[] marked;   // 这个顶点上调用过 dfs() 了吗？
    private int[] edgeTo;       // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;        // 起点
    
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }
    
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
    
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) {
            return null;
        }
        Bag<Integer> path = new Bag<Integer>();
        for(int x = v; x != s; x = edgeTo[x]) {
            path.add(x);
        }
        path.add(s);
        return path;
    }
}

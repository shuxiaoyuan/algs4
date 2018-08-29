package graph;

public class BreadthFirstSearch {
    private boolean[] marked;   // 到达该顶点的最短路径已知吗？
    private int[] edgeTo;       // 到达该顶点的已知路径上的最后一个顶点
    private final int s;        // 起点
    
    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }
    
    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;   // 标记起点
        queue.enqueue(s);   // 将它加入队列
        while(!queue.isEmpty()) {
            int v = queue.dequeue();    // 从队列中删去下一顶点
            for(int w : G.adj(v)) {
                if(!marked[w]) {        // 对于每个未被标记的相邻顶点
                    edgeTo[w] = v;      // 保存最短路径的最后一条边
                    marked[w] = true;   // 标记它，因为最短路径已知
                    queue.enqueue(w);   // 并将它添加到队列中
                }
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
        Bag<Integer> path = new Bag<>();
        for(int x = v; x != s; x = edgeTo[x]) {
            path.add(x);
        }
        path.add(s);
        return path;
    }
    
}

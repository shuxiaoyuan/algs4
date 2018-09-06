package graphs;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class LazyPrimMST {
    private boolean[] marked;       // 最小生成树的顶点
    private ArrayDeque<Edge> mst;   // 最小生成树的边
    private PriorityQueue<Edge> pq; // 横切边
    
    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new PriorityQueue<>(G.E());
        marked = new boolean[G.V()];
        mst = new ArrayDeque<>(G.E());
        
        visit(G, 0);
        while(!pq.isEmpty()) {
            Edge e = pq.poll();             // 从 pq 中得到权重最小的边
            int v = e.either();
            int w = e.other(v);
            if(marked[v] && marked[w]) {    // 跳过失效的边
                continue;
            }
            mst.offer(e);                   // 将边添加到最小生成树中
            if(!marked[v]) {                // 将顶点（v 或 w）添加到树中
                visit(G, v);
            }
            if(!marked[w]) {
                visit(G, w);
            }
        }
    }
    
    private void visit(EdgeWeightedGraph G, int v) {
        // 标记顶点 v 并将所有连接 v 和未被标记顶点的边加入 pq
        marked[v] = true;
        for(Edge e : G.adj(v)) {
            if(!marked[e.other(v)]) {
                pq.offer(e);
            }
        }
    }
    
    public Iterable<Edge> edges() {
        return mst;
    }
    
}

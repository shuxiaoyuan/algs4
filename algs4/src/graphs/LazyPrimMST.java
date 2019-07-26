package graphs;


import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import fundamentals.Queue;


/**
 * Author: lishuyuan
 * Date&Time: 2019/7/26 10:57
 * Description: P400 最小生成树的 Prim 算法的延时实现
 */
public class LazyPrimMST {

    private boolean[] marked;   // 最小生成树的顶点
    private Queue<Edge> mst;    // 最小生成树的边
    private MinPQ<Edge> pq;     // 横切边（包括失效的边）

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();

        visit(G, 0);                             // 假设 G 是连通的
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();                   // 从 pq 中得到权重最小的边
            int v = e.either(), w = e.other(v);
            if(marked[v] && marked[w]) continue;    // 跳过失效的边
            mst.enqueue(e);                         // 将边添加到树中
            if(!marked[v]) visit(G, v);             // 将顶点（v或w）添加到树中
            if(!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        // 标记顶点 v 并将所有连接 v 和未被标记顶点的边加入 pq
        marked[v] = true;
        for(Edge e : G.adj(v)) {
            if(!marked[e.other(v)]) pq.insert(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

}

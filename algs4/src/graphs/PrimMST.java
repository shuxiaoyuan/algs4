package graphs;


import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * Author: lsy
 * Date&Time: 2019/7/26 14:11
 * Description: P403 算法 4.7 最小生成树的 Prim 算法（即时版本）
 */
public class PrimMST {

    private Edge[] edgeTo;          // 距离树最近的边
    private double[] distTo;        // distTo[w] = edgeTo[w].weight()
    private boolean[] marked;       // 如果 V 在树中则为 true
    private IndexMinPQ<Double> pq;  // 有效的横切边

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for(int v = 0; v < G.V(); ++v) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(G.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        // 将顶点 v 添加到树中，更新数据
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue; // v-w 失效
            if (e.weight() < distTo[w]) {
                // 连接 w 和树的最佳边 Edge 变为 e
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else                pq.insert(w, distTo[w]);
            }
        }
    }

}

package graphs;


import edu.princeton.cs.algs4.*;


/**
 * Author: lsy
 * Date&Time: 2019/7/26 14:56
 * Description: P406 算法4.8 最小生成树的 Kruskal 算法
 */
public class KruskalMST {

    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : G.edges()) pq.insert(e);
        UF uf = new UF(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();                   // 从 pq 得到权重最小的边和它的顶点
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) continue;       // 忽略失效的边
            uf.union(v, w);                         // 合并分量
            mst.enqueue(e);                         // 将边添加到最小生成树中
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

}

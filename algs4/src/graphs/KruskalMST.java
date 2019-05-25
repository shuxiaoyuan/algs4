package graphs;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

import fundamentals.WeightedQuickUnionUF;

public class KruskalMST {
    private ArrayDeque<Edge> mst;
    
    public KruskalMST(EdgeWeightedGraph G) {
        mst = new ArrayDeque<Edge>();
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for(Edge e : G.edges()) {
            pq.offer(e);
        }
        WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(G.V());
        while(!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();         // 从 pq 得到权重最小的边和它的顶点
            int v = e.either();     
            int w = e.other(v);
            if(wqu.connected(v, w)) {   // 忽略失效的边
                continue;
            }
            wqu.union(v, w);            // 合并分量
            mst.offer(e);               // 将边添加到最小生成树中
        }
    }
    
    public Iterable<Edge> edges() {
        return mst;
    }
    
}

package graphs;

import java.util.ArrayDeque;

public class EdgeWeightedGraph {
    private final int V;            // 顶点总数
    private int E;                  // 边的总数
    private ArrayDeque<Edge>[] adj; // 邻接表
    
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayDeque<Edge>[]) new ArrayDeque[V];
        for(int v = 0; v < V; v++) {
            adj[v] = new ArrayDeque<Edge>();
        }
    }
    
    public int V() {
        return V;
    }
    
    public int E() {
        return E;
    }
    
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
    
    public Iterable<Edge> edges() {
        ArrayDeque<Edge> edges = new ArrayDeque<>();
        for(int v = 0; v < V; v++) {
            for(Edge e : adj[v]) {
                if(e.other(v) > v) {
                    edges.add(e);
                }
            }
        }
        return edges;
    }
    
}

package graphs;

import fundamentals.Bag;

/**
 * Author: Sean Lee
 * Date&Time: 2019年6月17日 下午2:47:15
 * Description: P336 Graph 数据类型 
*/
public class Graph {

    private final int V;        // 顶点数目
    private int E;              // 边的数目
    private Bag<Integer>[] adj; // 邻接表
    
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];  // 创建邻接表
        for(int v = 0; v < V; ++v) {
            adj[v] = new Bag<Integer>();    // 将所有链表初始化为空
        }
    }
    
    public int V() {
        return V;
    }
    
    public int E() {
        return E;
    }
    
    public void addEdge(int v, int w) {
        adj[v].add(w);  // 将 w 添加到 v 的链表中
        adj[w].add(v);  // 将 v 添加到 w 的链表中
        ++E;
    }
    
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    
}

package graph;

import java.util.ArrayDeque;

public class DepthFirstOrder {
    private boolean[] marked;
    private ArrayDeque<Integer> pre;            // 所有顶点的前序排列
    private ArrayDeque<Integer> post;           // 所有顶点的后序排序
    private ArrayDeque<Integer> reversePost;    // 所有顶点的逆后序排序
    
    public DepthFirstOrder(Digraph G) {
        pre = new ArrayDeque<Integer>();
        post = new ArrayDeque<Integer>();
        reversePost = new ArrayDeque<Integer>();
        marked = new boolean[G.V()];
        for(int v = 0; v < G.V(); v++) {
            if(!marked[v]) {
                dfs(G, v);
            }
        }
    }
    
    private void dfs(Digraph G, int v) {
        pre.add(v);
        marked[v] = true;
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }
    
    public Iterable<Integer> pre() {
        return pre;
    }
    
    public Iterable<Integer> post() {
        return post;
    }    
    
    public Iterable<Integer> reversePost() {
        return reversePost;
    }
    
}

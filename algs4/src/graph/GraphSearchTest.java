package graph;

public class GraphSearchTest {
    public static void main(String[] args) {
        
        // 新建图并填入边信息
        Graph G = new Graph(6);
        G.addEdge(0, 5);
        G.addEdge(2, 4);
        G.addEdge(2, 3);
        G.addEdge(1, 2);
        G.addEdge(0, 1);
        G.addEdge(3, 4);
        G.addEdge(3, 5);
        G.addEdge(0, 2);
        
        // dfs
        DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
        System.out.print("dfs path 0 to 5: ");
        Iterable<Integer> path = dfs.pathTo(5);
        for(int v : path) {
            if(v != 0) {
                System.out.print("->");
            }
            System.out.print(v);
        }
        
    }
}

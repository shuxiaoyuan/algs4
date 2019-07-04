package graphs;

/**
 * Author: lishuyuan
 * Date&Time: 2019年7月4日 下午4:22:39
 * Description: P367 算法4.4 有向图的可达性
 */
public class DirectedDFS {

	private boolean[] marked;
	
	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
	}
}

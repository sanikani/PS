import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<List<Edge>> graph = new ArrayList<>();
    static boolean[] visited;
    static int maxDist = 0;
    static int farNode = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(p).add(new Edge(c, w));
            graph.get(c).add(new Edge(p, w));
        }
        
        visited = new boolean[n + 1];
        dfs(1, 0);
        
        visited = new boolean[n + 1];
        maxDist = 0;
        dfs(farNode, 0);
        
        System.out.println(maxDist);
	}
	
	static void dfs(int cur, int dist) {
		visited[cur] = true;
		
		if(dist > maxDist) {
			maxDist = dist;
			farNode = cur;
		}
		
		for (Edge edge : graph.get(cur)) {
			if(visited[edge.to]) continue;
			dfs(edge.to, dist + edge.w);
		}
	}
	
	static class Edge{
		int to;
		int w;
		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}
}

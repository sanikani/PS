import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge{
		int v;
		int w;
		
		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Edge>> graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Edge(v, w));
			graph.get(v).add(new Edge(u, w));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
		boolean[] vis = new boolean[n + 1];
		
		int total = 0;
		int max = 0;
		pq.offer(new Edge(1, 0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(vis[cur.v]) continue;
			
			vis[cur.v] = true;
			total += cur.w;
			max = Math.max(max, cur.w);
			for (Edge next : graph.get(cur.v)) {
				if(vis[next.v]) continue;
				pq.offer(next);
			}
		}
		
		System.out.println(total - max);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			makeSet(n);
			int[][] pos = new int[n][2];
			
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					pos[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			double k = Double.parseDouble(br.readLine());
			List<Edge> edges = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					long w = (long) (Math.pow(Math.abs(pos[i][0] - pos[j][0]), 2)
							+ Math.pow(Math.abs(pos[i][1] - pos[j][1]), 2));
					edges.add(new Edge(i, j, w));
				}
			}
			
			Collections.sort(edges, (e1, e2) -> Long.compare(e1.w, e2.w));
			
			long cost = 0;
			for (Edge edge : edges) {
				if(find(edge.u) != find(edge.v)) {
					union(edge.u, edge.v);
					cost += edge.w;
				}
			}
			
			sb.append('#').append(tc).append(' ').append(Math.round(cost * k)).append('\n');
		}
		System.out.println(sb);
	}
	
	static class Edge{
		int u;
		int v;
		long w;
		
		public Edge(int u, int v, long w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	static void makeSet(int n) {
		parent = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int n) {
		if(parent[n] == n) return n;
		
		return parent[n] = find(parent[n]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) parent[pb] = pa;
	}
}

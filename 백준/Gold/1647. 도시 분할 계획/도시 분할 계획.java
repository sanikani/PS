import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	
	static class Edge{
		int u;
		int v;
		int w;
		
		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) return false;
		parent[pb] = pa;
		return true;
	}
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
		    parent[i] = i;
		}
		Edge[] edges = new Edge[m];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(u, v, w);
		}
		
		Arrays.sort(edges, Comparator.comparingInt(e -> e.w));
		
		int total = 0;
		int max = 0;
		int count = 0;
		
		for(Edge edge : edges) {
			if(union(edge.u, edge.v)) {
				total += edge.w;
				max = edge.w;
				count++;
				if(count == n - 1) break;
			}
		}
		
		System.out.println(total - max);
	}
}

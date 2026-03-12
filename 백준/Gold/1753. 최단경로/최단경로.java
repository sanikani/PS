import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static int E;
	static int start;
	static List<List<Node>> graph;
	static int[] minDist;
	
	static class Node{
		int v;
		int w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		minDist = new int[V+1];
		
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
			minDist[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, w));
		}
		
		System.out.println(solution());
	}

	private static String solution() {
		StringBuilder sb = new StringBuilder();
		
		minDist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			
			Node cur = pq.poll();
			
			if(minDist[cur.v] < cur.w) continue;
			
			for(Node node : graph.get(cur.v)) {
				
				int nextV = node.v;
				int nextW = cur.w + node.w;
				
				if(minDist[nextV] > nextW) {
					
					minDist[nextV] = nextW;
					pq.offer(new Node(nextV, nextW));
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			
			if(minDist[i] == Integer.MAX_VALUE) sb.append("INF");
			else sb.append(minDist[i]);
			sb.append('\n');
		}
		
		return sb.toString();
	}
}

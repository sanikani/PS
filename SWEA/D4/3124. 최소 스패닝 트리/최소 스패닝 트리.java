import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<List<Node>> graph = new ArrayList<>();
			for(int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				
				graph.get(a).add(new Node(b, c));
				graph.get(b).add(new Node(a, c));
			}
			
			boolean[] visited = new boolean[V + 1];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			long cost = 0;
			int cnt = 0;
			
			pq.offer(new Node(1, 0));
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(visited[cur.v]) continue;
				
				visited[cur.v] = true;
				cost += cur.w;
				cnt++;
				
				if(cnt == V) break;
				
				for (Node next : graph.get(cur.v)) {
					if(!visited[next.v]) {
						pq.offer(new Node(next.v, next.w));
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(cost).append('\n');
		}
		System.out.println(sb);
	}
	
	static class Node implements Comparable<Node>{
		int v;
		long w;
		
		public Node(int v, long w) {
			this.v = v;
			this.w = w;
		}

		public int compareTo(Node o) {
			return Long.compare(this.w, o.w);
		}
	}
}

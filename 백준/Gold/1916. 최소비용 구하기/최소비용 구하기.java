import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<List<Node>> graph = new ArrayList<>();
		long[] minDist = new long[N + 1];
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			minDist[i] = Long.MAX_VALUE;
		}
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		System.out.println(diijkstra(N, M, graph, start, end, minDist));
		
	}
	
	private static long diijkstra(int n, int m, List<List<Node>> graph, int start, int end, long[] minDist) {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Long.compare(n1.w, n2.w));
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.w > minDist[cur.v]) continue;
			if(cur.v == end) break;
			
			for(Node node : graph.get(cur.v)) {
				long nextW = cur.w + node.w;
				
				if(minDist[node.v] > nextW) {
					pq.offer(new Node(node.v, nextW));
					minDist[node.v] = nextW;
				}
			}
		}
		
		return minDist[end];
	}

	static class Node{
		int v;
		long w;
		public Node(int v, long w) {
			this.v = v;
			this.w = w;
		}
	}
}

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
			int n = Integer.parseInt(br.readLine());
			int[][] pos = new int[n][2];
			
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					pos[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			double k = Double.parseDouble(br.readLine());
			List<List<Node>> nodes = new ArrayList<>();
			for(int i = 0; i <= n; i++) nodes.add(new ArrayList<>());
			
			makeNodes(n, pos, nodes);
			
			sb.append('#').append(tc).append(' ').append(Math.round(prim(n, nodes) * k)).append('\n');
		}
		System.out.println(sb);
	}
	
	static class Node{
		int v;
		long w;
		
		public Node(int v, long w) {
			this.v = v;
			this.w = w;
		}
	}

	private static void makeNodes(int n, int[][] pos, List<List<Node>> nodes) {
		for (int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				long w = (long) (Math.pow(Math.abs(pos[i][0] - pos[j][0]), 2)
						+ Math.pow(Math.abs(pos[i][1] - pos[j][1]), 2));
				nodes.get(i).add(new Node(j, w));
				nodes.get(j).add(new Node(i, w));
			}
		}
	}

	private static long prim(int n, List<List<Node>> nodes) {
		PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.w, e2.w));
		boolean[] visited = new boolean[n + 1];
		pq.offer(new Node(1, 0));
		long cost = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.v]) continue;
			
			visited[cur.v] = true;
			cost += cur.w;
			cnt++;
			
			if(cnt == n) break;
			
			for (Node node : nodes.get(cur.v)) {
				if(!visited[node.v]) pq.offer(new Node(node.v, node.w));
			}
		}
		return cost;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static List<List<Node>> nodes;
	static int[] costs;
	static int[][] weights;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		costs = new int[n];
		for (int i = 0; i < n; i++) {
			costs[i] = Integer.parseInt(br.readLine());
		}
		
		weights = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				weights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solution(n));
	}
	
	private static int solution(int n) {
		
		nodes = new ArrayList<>();
		for(int i = 0; i < n; i++) nodes.add(new ArrayList<>());
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j) {
					nodes.get(i).add(new Node(j, weights[i][j]));
				}				
			}
		}
		
		
		boolean[] vis = new boolean[n];
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
		
		for(int i = 0; i < n; i++) pq.offer(new Node(i, costs[i]));
		
		int cnt = 0;
		int cost = 0;
		
		while(!pq.isEmpty()) {
			
			Node cur = pq.poll();
			if(vis[cur.v]) continue;
			
			vis[cur.v] = true;
			cost += cur.w;
			cnt++;
			
			if(cnt == n) return cost;
			
			for (Node node : nodes.get(cur.v)) {
				if(!vis[node.v]) {
					pq.offer(new Node(node.v, node.w));
				}
			}
		}
		
		return cost;
	}

	static class Node{
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}

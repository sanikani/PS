import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] values;
	static List<List<Node>> graph;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		values = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
			graph.get(v).add(new Node(u, w));
		}
		
		int max = 0;
		for(int i = 1; i <= n; i++) {
			max = Math.max(max, dst(i));
		}
		
		System.out.println(max);
	}
	
	private static int dst(int i) {
		int[] minDist = new int[n + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[i] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.w));
		pq.add(new Node(i, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.w > minDist[cur.v]) continue;
			
			for(Node next : graph.get(cur.v)) {
				int nextW = cur.w + next.w;
				if(nextW < minDist[next.v]) {
					minDist[next.v] = nextW;
					pq.offer(new Node(next.v, nextW));
				}
			}
		}
		
		int sum = 0;
		for(int k = 0; k <= n; k++) {
			if(minDist[k] <= m) {
				sum += values[k];
			}
		}
		return sum;
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

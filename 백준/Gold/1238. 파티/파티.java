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
	static int[] minDist;
	static int[] reversMinDist;
	static int n;
	static int m;
	static int x;
	static List<List<Node>> graph;
	static List<List<Node>> reversGraph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		reversGraph = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			reversGraph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
			reversGraph.get(v).add(new Node(u, w));
		}
		
		minDist = new int[n + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[x] = 0;
		dijkstra(graph, minDist);
		
		reversMinDist = new int[n + 1];
		Arrays.fill(reversMinDist, Integer.MAX_VALUE);
		reversMinDist[x] = 0;
		dijkstra(reversGraph, reversMinDist);
		
		int max = 0;
		for(int i = 1; i <= n; i++) {
			max = Math.max(max, minDist[i] + reversMinDist[i]);
		}
		System.out.println(max);
		
	}
	
	static class Node{
		int v;
		int w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static void dijkstra(List<List<Node>> list, int[] minDist) {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.w));
		pq.offer(new Node(x, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(minDist[cur.v] < cur.w) continue;
			
			for (Node next : list.get(cur.v)) {
				if(minDist[next.v] > cur.w + next.w) {
					minDist[next.v] = cur.w + next.w;
					pq.add(new Node(next.v, minDist[next.v]));
				}
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] grid;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
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
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			graph = new ArrayList<>();
			minDist = new int[N * N + 1];
			
			for(int i = 0; i <= N*N; i++) {
				graph.add(new ArrayList<>());
				minDist[i] = Integer.MAX_VALUE;
			}
			
			grid = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int cur = i*N + j + 1;
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						int next = nr*N + nc + 1;
						graph.get(cur).add(new Node(next, grid[nr][nc]));
					}
				}
			}
			
			diijkstra();
			
			sb.append("Problem ").append(cnt++).append(": ").append(minDist[N*N] + grid[0][0]).append('\n');
		}
		System.out.println(sb);
	}
		
		

	private static void diijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)-> Integer.compare(n1.w, n2.w));
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
            
			if(cur.v == N*N) break;
			if(cur.w > minDist[cur.v]) continue;
			
			for (Node node : graph.get(cur.v)) {
				int nextV = node.v;
				int nextW = cur.w + node.w;
				if(minDist[nextV] > nextW) {
					minDist[nextV] = nextW;
					pq.add(new Node(nextV, nextW));
				}
			}
		}
	}
}

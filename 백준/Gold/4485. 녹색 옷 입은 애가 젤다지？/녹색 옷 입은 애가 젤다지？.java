import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] grid;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
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
			minDist = new int[N * N + 1];
			
			for(int i = 0; i <= N*N; i++) {
				minDist[i] = Integer.MAX_VALUE;
			}
			
			grid = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
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
			int idx = cur.v - 1;
			int r = idx/N;
			int c = idx%N;
			if(cur.v == N*N) break;
			if(cur.w > minDist[cur.v]) continue;
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				int nextV = nr*N + nc + 1;
				int nextW = cur.w + grid[nr][nc];
				
				if(minDist[nextV] > nextW) {
					minDist[nextV] = nextW;
					pq.add(new Node(nextV, nextW));
				}
			}
		}
	}
}

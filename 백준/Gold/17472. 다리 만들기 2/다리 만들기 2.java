import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] grid;
	static int islandNum;
	static int n;
	static int m;
	static List<Edge> edges = new ArrayList<>();
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		grid = new int[n][m];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		islandNum = 0;
		checkIsland();
		makeEdges();
		Collections.sort(edges, (e1, e2) -> e1.w - e2.w);
		parents = new int[islandNum+1];
		for(int i = 1; i <= islandNum; i++) parents[i] = i;
		int cost = 0;
		int cnt = 0;
		
		for (Edge edge : edges) {
			if(find(edge.u) != find(edge.v)) {
				union(edge.u, edge.v);
				cost += edge.w;
				cnt++;
			}
			
			if(cnt == islandNum - 1) break;
		}
		
		if(cnt < islandNum - 1) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(cost);
	}
	
	private static void makeEdges() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] != 0) {
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(notInRange(n, m, nr, nc)) continue;
						if(grid[nr][nc] == grid[i][j]) continue;
						connect(nr, nc, grid[i][j], d);
					}
					
				}
			}
		}
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) parents[pb] = pa;
	}

	private static void connect(int r, int c, int islandNum, int d) {
		int len = 1;
		while(true) {
			r += dr[d];
			c += dc[d];
			if(notInRange(n, m, r, c)) return;
			if(grid[r][c] == islandNum) return;
			if(grid[r][c] != 0 && len == 1) return;
			
			if(grid[r][c] != 0) {
				edges.add(new Edge(islandNum, grid[r][c], len));
				return;
			}
			len++;
		}
	}

	private static void checkIsland() {
		boolean[][] visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
					changeIslandNum(i, j, visited);
				}
			}
		}
	}

	private static void changeIslandNum(int i, int j, boolean[][] visited) {
		islandNum++;
		Queue<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		grid[i][j] = islandNum;
		q.offer(new int[] {i, j});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(notInRange(n, m, nr, nc)) continue;
				if(grid[nr][nc] == 0) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				grid[nr][nc] = islandNum;
				q.offer(new int[] {nr, nc});
			}
		}
		
	}

	private static boolean notInRange(int r, int c, int nr, int nc) {
		return nr < 0 || nr >= r || nc < 0 || nc >= c;
	}
	
	static class Edge{
		int u, v, w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
}

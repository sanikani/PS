import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] grid;
	static List<int[]> virus;
	static List<int[]> empty;
	static int max;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		virus = new ArrayList<>();
		empty = new ArrayList<>();
		max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 2) virus.add(new int[] {i, j});
				if(value == 0) empty.add(new int[] {i, j});
				grid[i][j] = value;
			}
		}
		createWall();
		System.out.println(max);
	}
	
	static void createWall() {
		int e = empty.size();
		
		for(int a = 0; a < e - 2; a++) {
			for(int b = a + 1; b < e - 1; b++) {
				for(int c = b +1; c < e; c++) {
					int[] w1 = empty.get(a);
					int[] w2 = empty.get(b);
					int[] w3 = empty.get(c);
					
					grid[w1[0]][w1[1]] = 1;
					grid[w2[0]][w2[1]] = 1;
					grid[w3[0]][w3[1]] = 1;
					
					max = Math.max(max, bfs());
					
					grid[w1[0]][w1[1]] = 0;
					grid[w2[0]][w2[1]] = 0;
					grid[w3[0]][w3[1]] = 0;
				}
			}
		}
		
	}

	private static int bfs() {
		boolean[][] visited = new boolean[N][M];
		
		Queue<int[]> q = new ArrayDeque<>();
		for(int[] v : virus) {
			q.offer(v);
			visited[v[0]][v[1]] = true;
		}
		
		while(!q.isEmpty()) {
			int[] v = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = v[0] + dr[d];
				int nc = v[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(visited[nr][nc]) continue;
				if(grid[nr][nc] != 0) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (!visited[i][j] && grid[i][j] == 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}
}

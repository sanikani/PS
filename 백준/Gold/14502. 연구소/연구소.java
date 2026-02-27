import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] grid;
	static List<int[]> virus;
	static int max;
	static int[][] walls;
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		virus = new ArrayList<>();
		max = 0;
		walls = new int[3][2];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 2) virus.add(new int[] {i, j});
				grid[i][j] = value;
			}
		}
		dfs(0);
		System.out.println(max);
	}
	
	static void dfs(int l) {
		if(l == 3) {
			max = Math.max(max, bfs()); 
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) continue;
				if(grid[i][j] == 1 || grid[i][j] == 2) continue;
				visited[i][j] = true;
				walls[l][0] = i;
				walls[l][1] = j;
				dfs(l + 1);
				visited[i][j] = false;
			}
		}
		
	}

	private static int bfs() {
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = Arrays.copyOf(grid[i], M);
		}
		
		for(int[] wall : walls) {
			map[wall[0]][wall[1]] = 1;
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		for(int[] v : virus) {
			q.offer(v);
		}
		
		while(!q.isEmpty()) {
			int[] v = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = v[0] + dr[d];
				int nc = v[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(map[nr][nc] == 2 || map[nr][nc] == 1) continue;
				map[nr][nc] = 2;
				q.offer(new int[] {nr, nc});
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}
}

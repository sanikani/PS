import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] grid = new int[N][N];
		boolean[][] vis = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				grid[i][j] = s.charAt(j) - '0';
			}
		}
		
		List<Integer> counts = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(grid[i][j] == 1 && !vis[i][j]) {
					counts.add(bfs(N, i, j, grid, vis));
				}
			}
		}
		counts.sort(Integer::compareTo);
		StringBuilder sb = new StringBuilder();
		sb.append(counts.size()).append('\n');
		for (Integer i : counts) {
			sb.append(i).append('\n');
		}
		System.out.println(sb);
	}

	private static int bfs(int n, int i, int j, int[][] grid, boolean[][] vis) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		vis[i][j] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			int[] cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
				if(vis[nr][nc]) continue;
				if(grid[nr][nc] == 0) continue;
				q.offer(new int[] {nr, nc});
				vis[nr][nc] = true;
			}
		}
		return cnt;
	}
}

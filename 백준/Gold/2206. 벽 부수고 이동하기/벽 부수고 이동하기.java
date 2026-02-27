import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] grid = new int[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				grid[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(N, M, grid));
	}

	private static int bfs(int n, int m, int[][] grid) {
		if(n == 1 && m == 1) return 1;
		boolean[][] visited = new boolean[n][m];
		boolean[][] visitedAfterBreak = new boolean[n][m];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0});
		visited[0][0] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int len = q.size();
			for(int i = 0; i < len; i++) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int isBreak = cur[2];
				
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
					if(grid[nr][nc] == 1) {
						if(isBreak == 1) continue;
						if(visitedAfterBreak[nr][nc]) continue;
						visitedAfterBreak[nr][nc] = true;
						q.offer(new int[] {nr, nc, 1});
					}else {
						if(isBreak == 0) {
							if(visited[nr][nc]) continue;
							visited[nr][nc] = true;
						}else {
							if(visitedAfterBreak[nr][nc]) continue;
							visitedAfterBreak[nr][nc] = true;
						}
						if(nr == n - 1 && nc == m - 1) return cnt + 1;
						q.offer(new int[] {nr, nc, isBreak});
					}
				}
			}
			cnt++;
		}
		return -1;
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] visited;
	static int N;
	static int K;
	static int max;
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			max = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			int maxHeight = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > maxHeight) maxHeight = map[i][j];
				}
			}
			
			List<int[]> peaks = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == maxHeight) peaks.add(new int[] {i, j});
				}
			}
			
			for(int[] peak : peaks) {
				visited[peak[0]][peak[1]] = true;
				dfs(1, peak[0], peak[1], false);
				visited[peak[0]][peak[1]] = false;
			}
			
			sb.append('#').append(test_case).append(' ').append(max).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int l, int r, int c, boolean flag) {
		max = Integer.max(max, l);
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(visited[nr][nc]) continue;

			if(map[nr][nc] >= map[r][c]) {
				if(flag) continue;
				if(map[nr][nc] - map[r][c] >= K) continue;
				
				visited[nr][nc] = true;
				
				int tmp = map[nr][nc];
				map[nr][nc] = map[r][c] - 1;
				
				dfs(l+1, nr, nc, true);
				
				map[nr][nc] = tmp;
				visited[nr][nc] = false;
			}else {
				visited[nr][nc] = true;
				dfs(l+1, nr, nc, flag);
				visited[nr][nc] = false;
			}
		}
	}
}

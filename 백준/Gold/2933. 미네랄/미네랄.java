import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static char[][] grid;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		grid = new char[R][C];
		for(int i = 0; i < R; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		int n = Integer.parseInt(br.readLine());
		solution(br, n);
		for (char[] chars : grid) {
			sb.append(chars).append('\n');
		}
		System.out.println(sb);
	}

	private static void solution(BufferedReader br, int n) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int next = R - Integer.parseInt(st.nextToken());
			//왼 오 오 왼 순서
			//0 1 2 3 4 5 6
			int targetC = -1;
			if(i % 2 == 0) {
				for(int c = 0; c < C; c++) {
					if(grid[next][c] == 'x') {
						targetC = c;
						break;
					}
				}
			}else {
				for(int c = C - 1; c >= 0; c--) {
					if(grid[next][c] == 'x') {
						targetC = c;
						break;
					}
				}
			}
			if(targetC == -1) continue;
			shot(next, targetC);
			
		}
	}

	private static void shot(int next, int targetC) {
		grid[next][targetC] = '.';
		for(int d = 0; d < 4; d++) {
			int nr = next + dr[d];
			int nc = targetC + dc[d];
			
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			if(grid[nr][nc] == '.') continue;
			//bfs로 클러스터인지 확인
			List<int[]> list = new ArrayList<>();
			if(isCluster(nr, nc, list)) {
				applyGravity(list);
				return;
			}
		}
	}

	private static void applyGravity(List<int[]> list) {
		Queue<int[]> q = new ArrayDeque<>();
		for (int[] p : list) {
			q.offer(p);
			grid[p[0]][p[1]] = '.';
		}
		int gravityLen = getGravityLen(q);
		
		for (int[] p : list) {
			grid[p[0] + gravityLen][p[1]] = 'x';
		}
	}

	private static int getGravityLen(Queue<int[]> q) {
		int gravityLen = 0;
		while(!q.isEmpty()) {
			int len = q.size();
			for(int i = 0; i < len; i++) {
				int[] cur = q.poll();
				
				int nr = cur[0] + 1;
				if(nr == R || grid[nr][cur[1]] == 'x') {
					return gravityLen;
				}
				q.offer(new int[] {nr, cur[1]});
			}
			gravityLen++;
		}
		return gravityLen;
	}

	private static boolean isCluster(int r, int c, List<int[]> list) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] vis = new boolean[R][C];
		int[] pos = new int[] {r, c};
		q.offer(pos);
		list.add(pos);
		vis[r][c] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if(vis[nr][nc] || grid[nr][nc] == '.') continue;
				if(nr == R - 1) return false;
				int[] next = new int[] {nr, nc};
				q.offer(next);
				list.add(next);
				vis[nr][nc] = true;
			}
		}
		return true;
	}
}

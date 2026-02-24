import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] shot;
	static int[][] grid;
	static int min;
	static int N;
	static int W;
	static int H;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			grid = new int[H][W];
			min = Integer.MAX_VALUE;
			shot = new int[N];
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, grid);
			sb.append('#').append(tc).append(' ').append(min).append('\n');
		}
		System.out.println(sb);
	}

	static void dfs(int l, int[][] board) {
		if(min == 0) return;
		if(l==N) {
			min = Math.min(min, count(board));
			return;
		}
		for(int i = 0; i < W; i++) {
			shot[l] = i;
			dfs(l+1, shot(i, board));
		}
	}

	private static int[][] shot(int s, int[][] board) {
		int[][] tmp = new int[H][W];
		for(int i = 0; i < H; i++) {
			tmp[i] = Arrays.copyOf(board[i], board[i].length);
		}
		for(int i = 0; i < H; i++) {
			if(tmp[i][s] != 0) {
				bfs(tmp, i, s);
				break;
			}
		}
		return tmp;
	}
	
	static int count(int[][] tmp) {
		int remain = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(tmp[i][j] > 0) remain++;
			}
		}
		return remain;
	}

	private static void bfs(int[][] tmp, int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c, tmp[r][c]});
		tmp[r][c] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int power = cur[2];
			
			for(int p = 1; p < power; p++) {
				for(int k = 0; k < 4; k++) {
					int nr = cur[0] + dr[k]*p;
					int nc = cur[1] + dc[k]*p;
					if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
					if(tmp[nr][nc] == 0) continue;
				
					if(tmp[nr][nc] > 1) {
						q.offer(new int[] {nr, nc, tmp[nr][nc]});
					}
					tmp[nr][nc] = 0;
				}
			}
		}
		//중력 적용
		for(int i = 0; i < W; i++) {
			int idx = H - 1;
			for(int j = H - 1; j >= 0; j--) {
				if(tmp[j][i] != 0) {
					int temp = tmp[j][i];
					tmp[j][i] = 0;
					tmp[idx--][i] = temp;
				}
			}
		}
	}
}
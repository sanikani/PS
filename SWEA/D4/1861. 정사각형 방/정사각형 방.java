import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] arr;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int num = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = bfs(i, j);
					if(cnt == max) {
						num = Math.min(num, arr[i][j]);
					}
					if(cnt > max) {
						max = cnt;
						num = arr[i][j];
					}
				}
			}
			sb.append('#').append(test_case).append(' ').append(num).append(' ').append(max).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int bfs(int r, int c) {
		int cnt = 0;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int len = q.size();
			for(int i = 0; i < len; i++) {
				int[] cur = q.poll();
				for(int j = 0; j < 4; j++) {
					int nr = cur[0] + dr[j];
					int nc = cur[1] + dc[j];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if(arr[cur[0]][cur[1]] + 1 == arr[nr][nc]) {
						q.add(new int[] {nr, nc});
					}
				}
			}
			cnt++;
		}
		return cnt;
	}
}

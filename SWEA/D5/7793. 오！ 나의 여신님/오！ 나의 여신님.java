import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static char[][] grid;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[] start = new int[2];
//	static int[] devil = new int[2];
	static List<int[]> devils;
	static int[] end = new int[2];
	static boolean[][] visited;
	static boolean[][] devilVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			grid = new char[N][M];
			visited = new boolean[N][M];
			devilVisited = new boolean[N][M];
			devils = new ArrayList<>();
			for(int i = 0 ; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < M; j++) {
					grid[i][j] = s.charAt(j);
					if(grid[i][j] == 'S') {
						start[0] = i;
						start[1] = j;
					}
					if(grid[i][j] == '*') {
						devils.add(new int[] {i, j});
					}
					if(grid[i][j] == 'D') {
						end[0] = i;
						end[1] = j;
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(solution()).append('\n');
		}
		System.out.println(sb);
	}
	private static String solution() {
		Queue<int[]> q = new ArrayDeque<>();
		Queue<int[]> devilQ = new ArrayDeque<>();
		for (int[] d : devils) {
			devilQ.offer(d);
			devilVisited[d[0]][d[1]] = true;
		}
		q.offer(start);
		visited[start[0]][start[1]] = true;
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			for(int i = 0; i < devilQ.size(); i++) {
				int[] cur = devilQ.poll();
				for(int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(devilVisited[nr][nc]) continue;
					if(grid[nr][nc] == 'D' || grid[nr][nc] == 'X') continue;
					grid[nr][nc] = '*';
					devilVisited[nr][nc] = true;
					devilQ.offer(new int[] {nr, nc});
				}
			}
			
			int len = q.size();
			
			for(int i = 0; i < len; i++) {
				int[] cur = q.poll();
				for(int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if(nr == end[0] && nc == end[1]) return String.valueOf(cnt);
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(grid[nr][nc] == 'X' || grid[nr][nc] == '*') continue;
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
			cnt++;
		}
		return "GAME OVER";
	}
}

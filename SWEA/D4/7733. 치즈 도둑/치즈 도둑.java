import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static Set<Integer> tastes;
	static boolean[][] eat;
	static int cnt;
	static int N;
	static int maxTaste;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			maxTaste = 0;
			tastes = new HashSet<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxTaste = Math.max(map[i][j], maxTaste);
					tastes.add(map[i][j]);
				}
			}
			
			sb.append('#').append(tc).append(' ').append(solution(map)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int solution(int[][] map) {
		int max = 1;
		eat = new boolean[N][N];
		
		for(int d = 1; d <= 100; d++) {
			if(d > maxTaste) return max;
			if(!tastes.contains(d)) continue;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == d) eat[i][j] = true;
				}
			}
			
			cnt = 0;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					//먹지 않았고 방문하지 않은 점에서 덩어리 방문 처리
					if(!eat[i][j] && !visited[i][j]) {
						check(i, j);
					}
				}
			}
			
			max = Math.max(max, cnt);
		}
		return max;
	}

	private static void check(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i, j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int k = 0; k < 4; k++) {
				int nr = cur[0] + dr[k];
				int nc = cur[1] + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(eat[nr][nc]) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}	
		}
		
		cnt++;
	}
}

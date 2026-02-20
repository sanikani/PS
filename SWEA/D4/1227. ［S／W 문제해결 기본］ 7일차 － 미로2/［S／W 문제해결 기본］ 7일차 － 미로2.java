import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int[][] map = new int[100][100];
			int startR = 0, startC = 0;
			for(int i = 0; i < 100; i++) {
				String str = br.readLine();
				for(int j = 0; j < 100; j++) {
					map[i][j] = str.charAt(j) - '0';
					if(map[i][j] == 2) {
						startR = i;
						startC = j;
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(solution(map, startR, startC)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int solution(int[][] map, int startR, int startC) {
		int result = 0;
		boolean[][] visited = new boolean[100][100];
		Queue<int[]> q = new ArrayDeque<>();
		visited[startR][startC] = true;
		q.offer(new int[] {startR, startC});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(map[cur[0]][cur[1]]==3) return 1;
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr < 0 || nr >= map.length || nc < 0 || nc >= map.length) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == 1) continue;
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		
		return result;
	}
}

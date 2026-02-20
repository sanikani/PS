import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] normalMap = new char[N][N];
		char[][] redGreenMap = new char[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			normalMap[i] = str.toCharArray();
			redGreenMap[i] = str.replace('R', 'G').toCharArray();
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(solution(normalMap)).append(' ').append(solution(redGreenMap));
		System.out.println(sb);
	}
	private static int solution(char[][] map) {
		int cnt = 0;
		int length = map.length;
		boolean[][] visited = new boolean[length][length];
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				if(visited[i][j]) continue;
				bfs(i, j, map[i][j], visited, map);
				cnt++;
			}
		}
		
		return cnt;
	}
	private static void bfs(int i, int j, char c, boolean[][] visited, char[][] map) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i, j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int k = 0; k < 4; k++) {
				int nr = cur[0] + dr[k];
				int nc = cur[1] + dc[k];
				
				if(nr < 0 || nr >= visited.length || nc < 0 || nc >= visited.length) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] != c) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		
	}
}

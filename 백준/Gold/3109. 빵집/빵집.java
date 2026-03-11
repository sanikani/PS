import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static char[][] grid;
	static int cnt;
	static int[] dr = {-1, 0, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		grid = new char[R][C];
		
		for(int i = 0; i < R; i++) grid[i] = br.readLine().toCharArray();
		
		System.out.println(soltuion());
	}
	
	private static int soltuion() {
		cnt = 0;
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			if(dfs(i, 0)) cnt++;
		}
		
		return cnt;
	}
	
	static boolean dfs(int r, int c) {
		visited[r][c] = true;
		
		if(c == C - 1) return true;
		
		for(int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + 1;
			
			if(nr < 0 || nr >= R || nc >= C) continue;
			if(visited[nr][nc] || grid[nr][nc] == 'x') continue;
			
			if(dfs(nr, nc)) return true;
		}
		
		return false;
	}
}

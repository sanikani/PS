import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] pos;
	static int n;
	static int min;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			
			pos = new int[n+2][2];
			min = Integer.MAX_VALUE;
			visited = new boolean[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n + 2; i++) {
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			dfs(0, pos[0][0], pos[0][1], 0);
			sb.append('#').append(tc).append(' ').append(min).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int l, int x, int y, int dist) {
		if(dist > min) return;
		
		if(l == n) {
			int result = dist + Math.abs(x - pos[1][0]) + Math.abs(y - pos[1][1]);
			min = Math.min(min, result);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			int nx = pos[i + 2][0];
			int ny = pos[i + 2][1];
			dfs(l + 1, nx, ny, dist + Math.abs(x - nx) + Math.abs(y - ny));
			visited[i] = false;
		}
	}
}

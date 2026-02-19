import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r;
	static int c;
	static int[][] box;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		box = new int[r][c];
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		for(int i = 0; i < r ; i++) {
			for(int j = 0; j < c; j++) {
				if(box[i][j] == 1) {
					q.offer(new int[] {i, j});
				}
			}
		}
		int result = bfs(q);
		
		System.out.println(check(result));
	}
	private static int check(int result) {
		for(int i = 0; i < r ; i++) {
			for(int j = 0; j < c; j++) {
				if(box[i][j] == 0) {
					return -1;
				}
			}
		}
		return result;
	}
	private static int bfs(Queue<int[]> q) {
		int d = 0;

		if(q.size() == r*c) return 0;
		
		while(!q.isEmpty()) {
			d++;
			
			int len = q.size();
			for(int i = 0; i < len; i++) {
				int[] cur = q.poll();
				
				for(int j = 0; j < 4; j++) {
					int nr = cur[0] + dr[j];
					int nc = cur[1] + dc[j];
					
					if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
					if(box[nr][nc] == -1 || box[nr][nc] == 1) continue;
					box[nr][nc] = 1;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		return d - 1;
	}
}

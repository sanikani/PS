import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static char[][] board;
	static boolean[][][] visited;
	
	private static int solution(int startR, int startC) {
		int cnt = 0;
		
		Queue<Minsik> q = new ArrayDeque<>();
		q.add(new Minsik(startR, startC, 0));
		visited[startR][startC][0] = true;
		
		while(!q.isEmpty()) {
			int len = q.size();
			for(int k = 0; k < len; k++) {
				Minsik cur = q.poll();
				for(int i = 0; i < 4; i++) {
					
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					char next = board[nr][nc];
					if(next == '#') continue;
					if(next == '1') return cnt + 1;
					
					int nextMask = cur.mask;
					
					if(isKey(next)) {
						nextMask = cur.addKey(next);
					}
					if(isDoor(next) && !cur.canOpen(next, nextMask)) {
						continue;
					}
					
					if(visited[nr][nc][nextMask]) continue;
					
					visited[nr][nc][nextMask] = true;
					q.add(new Minsik(nr, nc, nextMask));
				}
			}
			cnt++;
		}
		
		return -1;
	}
	
	private static boolean isKey(char c) {
		return c == 'a' || c == 'b' || c == 'c' || 
				c == 'd' || c == 'e' || c == 'f';
	}
	
	private static boolean isDoor(char c) {
		return c == 'A' || c == 'B' || c == 'C' || 
				c == 'D' || c == 'E' || c == 'F';
	}
	
	private static class Minsik{
		int r;
		int c;
		int mask;
		
		public Minsik(int r, int c, int mask) {
			this.r = r;
			this.c = c;
			this.mask = mask;
		}
		
		public int addKey(char key) {
			return mask | (1 << (key - 'a'));
		}

		boolean canOpen(char door, int nextMask){
			int need = 1 << (door - 'A');
			return (nextMask & need) != 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		visited = new boolean[N][M][64];
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray(); 
		}
		
		int startR = 0, startC = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == '0') {
					startR = i;
					startC = j;
				}
			}
		}
		System.out.println(solution(startR, startC));
	}
}

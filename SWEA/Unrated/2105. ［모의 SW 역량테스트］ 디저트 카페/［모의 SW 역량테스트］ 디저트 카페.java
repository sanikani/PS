import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {1, -1, -1, 1};
	static int N;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append('#').append(tc).append(' ').append(solution()).append('\n');
		}
		
		System.out.println(sb);
	}
	private static int solution() {
		max = -1;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				for(int i = 1; i < N - 1; i++) {
					for(int j = 1; j < N - 1; j++) {
						if(i == N - 2 && j == N - 2) break;
						int result = check(r, c, i, j);
						max = Math.max(max, result);
					}
				}
			}
		}
		
		return max;
	}
	
	private static int check(int r, int c, int i, int j) {
		Set<Integer> set = new HashSet<>();
	    int nr = r;
	    int nc = c;

	    set.add(map[nr][nc]);

	    int[] len = {i, j, i, j - 1};

	    for (int d = 0; d < 4; d++) {
	        for (int k = 0; k < len[d]; k++) {
	            nr += dr[d];
	            nc += dc[d];

	            if (inRange(nr, nc)) return -1;

	            if (!set.add(map[nr][nc])) return -1;
	        }
	    }
		
		return set.size();
	}
	
	private static boolean inRange(int tmpR, int tmpC) {
		return tmpR < 0 || tmpR >= N || tmpC < 0 || tmpC >= N;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[] xDr = {1, 1, -1, -1};
	static int[] xDc = {-1, 1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int allCost = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) allCost += M;
				}
			}
			sb.append('#').append(test_case).append(' ').append(solution(N, M, map, allCost)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int solution(int n, int m, int[][] map, int allCost) {
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				//모든 점에서 방범 범위 늘려가면서 확인
				max = Math.max(max, calMax(n, m, map, allCost, i, j));
			}
		}
		return max;
	}
	
	static int calMax(int n, int m, int[][] map, int allCost, int i, int j) {
		int max = 0;
		int K = 1;
		int homeCnt = 0;
		if(map[i][j] == 1) {
			homeCnt++;
			max = Math.max(max, homeCnt);
		}
		
		//방범 가격이 모든 집 비용 합보다 작을때까지
		while(K * K + (K -1)*(K - 1) < allCost) {
			for(int t = 0; t < 4; t++) {
				//중심에서 상하좌우 확인
				int r = i + dr[t]*K;
				int c = j + dc[t]*K;
				if(inRange(n, r, c)) {
					if (map[r][c] == 1) {
						homeCnt++;
					}
				}
				
				//대각선 사이 확인
				for(int x = 0; x < K - 1; x++) {
					r += xDr[t];
					c += xDc[t];
					if(inRange(n, r, c)) {
						
						if(map[r][c] == 1) {
							homeCnt++;
						}
					}
				}
			}
			
			K++;
			//손해를 보지 않을 때 최대 계산
			if(K * K + (K -1)*(K - 1) <= homeCnt*m) {
				max = Math.max(max, homeCnt);
				
			}			
		}
		return max;
	}
	
	static boolean inRange(int n, int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
}

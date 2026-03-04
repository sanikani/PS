import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int[][] grid = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append('#').append(tc).append(' ').append(solution(N, X, grid)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int solution(int n, int x, int[][] grid) {
		
		int cnt = 0;
		//가로
		for(int r = 0; r < n; r++) {
			boolean[] isPlace = new boolean[n];
			boolean flag = true;
			int h = grid[r][0];
			for(int c = 1; c < n; c++) {
				int cur = grid[r][c];
				if(h != cur) {
					int sub = h - cur;
					//현재 값보다 작음
					if(sub == 1) {
						if(!canPlace(x, grid, r, c, cur, false, isPlace)) {
							flag = false;
							break;
						}
						c += x - 1;
						h = grid[r][c];
					}
					//현재 값보다 큼 -> 왔던길에 경사로 건설해야됨
					else if(sub == -1) {
						if(!canPlaceReverse(x, grid, r, c-1, false, isPlace)) {
							flag = false;
							break;
						}
					}else {
						flag = false;
						break;
					}
				}
				h = grid[r][c];
			}
			if (flag) {
//				System.out.println("가로" + r);
				cnt++;
			}
		}
		
		//세로
		for(int c = 0; c < n; c++) {
			boolean flag = true;
			boolean[] isPlace = new boolean[n];
			int h = grid[0][c];
			for(int r = 1; r < n; r++) {
				int cur = grid[r][c];
				if(h != cur) {
					int sub = h - cur;
					//현재 값보다 작음
					if(sub == 1) {
						if(!canPlace(x, grid, r, c, cur, true, isPlace)) {
							flag = false;
							break;
						}
						r += x - 1;
						h = grid[r][c];
					}
					//현재 값보다 큼 -> 왔던길에 경사로 건설해야됨
					else if(sub == -1) {
						if(!canPlaceReverse(x, grid, r-1, c, true, isPlace)) {
							flag = false;
							break;
						}
					}else {
						flag = false;
						break;
					}
				}
				h = grid[r][c];
			}
			if (flag) {
//				System.out.println("세로" + c);
				cnt++;
			}
		}
		return cnt;
	}

	private static boolean canPlaceReverse(int x, int[][] grid, int r, int c, boolean isVertical, boolean[] isPlace) {
		int cur = grid[r][c];
		for(int k = 1; k < x; k++) {
			if(isVertical) {
				if(r - k < 0) return false;
				if(isPlace[r - k]) return false;
			}else {
				if(c - k < 0) return false;
				if(isPlace[c - k]) return false;
			}
			
			int target;
			if(isVertical) target = grid[r - k][c];
			else target = grid[r][c - k];
			if(cur != target) return false;
		}
		
		for (int k = 0; k < x; k++) {
	        int idx = isVertical ? (r - k) : (c - k);
	        isPlace[idx] = true;
	    }
		return true;
	}

	private static boolean canPlace(int x, int[][] grid, int r, int c, int cur, boolean isVertical, boolean[] isPlace) {
		for(int k = 1; k < x; k++) {
			if(isVertical) {
				if(r + k >= grid.length) return false;
				if(isPlace[r + k]) return false;
			}else {
				if(c + k >= grid.length) return false;
				if(isPlace[c + k]) return false;
			}
			
			int target;
			if(isVertical) target = grid[r + k][c];
			else target = grid[r][c + k];
			
			if(cur != target) return false;
		}
		
		for (int k = 0; k < x; k++) {
	        int idx = isVertical ? (r + k) : (c + k);
	        isPlace[idx] = true;
	    }
		return true;
	}
}

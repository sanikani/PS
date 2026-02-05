import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			sb.append('#').append(tc).append(' ').append(solution(board, N, M, C)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int solution(int[][] board, int n, int m, int c) {
		List<Bar> hList = new ArrayList<>();
		int max = 0;
		
		//가로 바 계산 후 저장
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j + m > n) continue;
				int sum = getHMax(Arrays.copyOfRange(board[i], j, j + m), m, c);
				hList.add(new Bar(i, j, sum));
			}
		}
		
		//가로-가로
		for (int i = 0; i < hList.size(); i++) {
		    for (int j = i + 1; j < hList.size(); j++) {
		        Bar b1 = hList.get(i);
		        Bar b2 = hList.get(j);

		        if (b1.r != b2.r) {
		            max = Math.max(max, b1.sum + b2.sum);
		            continue;
		        }

		        int left = Math.min(b1.c, b2.c);
		        int right = Math.max(b1.c, b2.c);
		        if (left + m > right) continue;

		        max = Math.max(max, b1.sum + b2.sum);
		    }
		}
		
		//최댓값 리턴
		return max;
	}

	private static int getHMax(int[] arr, int m, int c) {
		int[][] dp = new int[m+1][c+1];
		
		int[] arr2 = new int[m];
		for(int i = 0; i < m; i++) {
			arr2[i] = arr[i]*arr[i];
		}
				
		for(int i = 1; i <= m; i++) {
			for(int j = 0; j <= c; j++) {
				if(arr[i-1] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i-1]] + arr2[i-1]); 
				}
			}
		}

		return dp[m][c];
	}

	static class Bar{
		int r;
		int c;
		int sum;
		
		Bar(int r, int c, int sum) {
            this.r = r;
            this.c = c;
            this.sum = sum;
        }
	}
}

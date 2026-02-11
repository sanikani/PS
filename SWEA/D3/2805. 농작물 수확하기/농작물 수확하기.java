import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = s.charAt(j) - '0';
				}
			}
			
			
			sb.append('#').append(test_case).append(' ').append(solution(N, farm)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int solution(int n, int[][] farm) {
		int sum = 0;
		int mid = n / 2;
		int len = 0;
		int r = 0;
		
		while(len >= 0) {
			for(int c = mid - len; c <= mid + len; c++) {
				sum += farm[r][c];
			}
			if(r>=mid) {
				len--;
			}else {
				len++;
			}
			r++;
		}
		
		return sum;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N;
	static int[] pre;
	static int[] memo = new int[100000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			Arrays.fill(memo, -1);
			
			sb.append('#').append(test_case).append(' ').append(dfs(N)).append('\n');
		}
		System.out.println(sb);
	}

	private static int dfs(int n) {
		if(n < 10) return 0;
		if(memo[n] != -1) return memo[n];
		String s = String.valueOf(n);
		int len = s.length();
		
		int max = 0;
		for (int x = 1; x < (1 << (len - 1)); x++) {
			int k = cutAndMultiple(s, x);
			max = Math.max(max, dfs(k) + 1);
		}
		
		return memo[n] = max;
	}

	static int cutAndMultiple(String s, int x) {
		int start = 0;
		int mul = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if ((x & (1 << i)) != 0) {
				mul *= Long.parseLong(s.substring(start, i + 1));
				start = i + 1;
			}
		}
		mul *= Long.parseLong(s.substring(start));
		return mul;
	}
}

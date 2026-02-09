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
			
			int mask = count(N, 0);
			int target = (1<<10) - 1;
			
			int cnt = 2;
			while(mask != target) {
				mask = count(N*cnt, mask);
				cnt++;
			}
			
			sb.append('#').append(test_case).append(' ').append(N * (cnt - 1)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int count(int n, int mask) {
		while(n > 0) {
			int k = n % 10;
			mask |= 1 << k;
			n /= 10;
		}
		return mask;
	}
}

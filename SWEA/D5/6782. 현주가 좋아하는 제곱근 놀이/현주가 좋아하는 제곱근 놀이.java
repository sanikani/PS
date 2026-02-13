import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			long N = Long.parseLong(br.readLine());
			
			sb.append('#').append(test_case).append(' ').append(soution(N)).append('\n');
		}
		
		System.out.println(sb);
	}

	private static long soution(long n) {
		long cnt = 0;
		while(n != 2) {
			
			long r = (long) Math.ceil(Math.sqrt(n));
			long target = r * r;
			if(target != n) {
				cnt += target - n;
				n = target;
			}else {
				n = r;
				cnt++;
			}
		}
		
		return cnt;
	}
}

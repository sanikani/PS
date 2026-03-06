import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] tokens = new int[n];
		for(int i = 0; i < n; i++) {
			tokens[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(solution(n, k, tokens));
	}

	private static int solution(int n, int k, int[] tokens) {
		int cnt = 0;
		for(int i = n - 1; i >= 0; i--) {
			int amount = tokens[i];
			if(k >= amount) {
				cnt += k/amount;
				k -= k/amount * amount;
			}
		}
		return cnt;
	}
}

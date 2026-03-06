import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(solution(n, scores));
	}
	
	static int solution(int n, int[] scores) {
		if(n == 1) return scores[1];
		if(n == 2) return scores[1] + scores[2];
		int dp[] = new int[n + 1];
		dp[1] = scores[1];
		dp[2] = scores[1] + scores[2];
		dp[3] = Math.max(scores[1] + scores[3], scores[2] + scores[3]);
		if(n == 3) return dp[3];
		for(int i = 4; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2] + scores[i],
					dp[i - 3] + scores[i - 1] + scores[i]);
		}
		return dp[n];
	}
}

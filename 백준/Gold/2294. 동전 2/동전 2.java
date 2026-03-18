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
		int[] coins = new int[n];
		for(int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[k+1];
		for(int money = 1; money <= k; money++) {
			for(int coin : coins) {
				if(money - coin < 0) continue;
				if(dp[money - coin] > 0) {
					if(dp[money] != 0) {
						dp[money] = Math.min(dp[money], dp[money - coin] + 1);
					}else {
						dp[money] = dp[money - coin] + 1;
					}
				}else {
					if(money % coin != 0) continue;
					dp[money] = money / coin;
				}
			}
		}
		if(dp[k] == 0) System.out.println(-1);
		else System.out.println(dp[k]);
	}
}



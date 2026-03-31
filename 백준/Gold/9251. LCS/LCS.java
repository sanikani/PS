import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int[][] dp = new int[s1.length()+ 1][s2.length() + 1];
		
		for(int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			for(int j = 0; j < s2.length(); j++) {
				if(c1 == s2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				}else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		System.out.println(dp[s1.length()][s2.length()]);
	}
}
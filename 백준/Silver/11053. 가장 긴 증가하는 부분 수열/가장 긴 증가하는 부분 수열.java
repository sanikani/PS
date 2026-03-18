import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dfs(i));
        }
        
        System.out.println(answer);
    }

    private static int dfs(int i) {
        if(dp[i] != 0) return dp[i];

        dp[i] = 1;

        for (int j = i + 1; j < n; j++) {
            if (arr[j] > arr[i]) {
                dp[i] = Math.max(dp[i], dfs(j) + 1);
            }
        }
        return dp[i];
    }
}

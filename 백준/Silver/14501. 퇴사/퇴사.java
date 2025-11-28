import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        int[][] reservation = new int[N+1][2];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            reservation[i][0] = Integer.parseInt(st.nextToken());
            reservation[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+2];
        for(int i=1; i<=N+1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i]);

            if (i <= N) {
                int nextDay = i + reservation[i][0];
                if (nextDay <= N+1) {
                    dp[nextDay] = Math.max(dp[nextDay], dp[i]+reservation[i][1]);
                }
            }
        }
        
        System.out.println(dp[N+1]);
    }
}
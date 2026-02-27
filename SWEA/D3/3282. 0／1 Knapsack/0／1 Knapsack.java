import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int K;
    static int[] weights;
    static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            weights = new int[N+1];
            values = new int[N+1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                weights[i] = Integer.parseInt(st.nextToken());
                values[i] = Integer.parseInt(st.nextToken());
            }
            sb.append('#').append(tc).append(' ').append(dp()).append('\n');
        }
        System.out.println(sb);
    }

    private static int dp(){
        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i <= N; i++){
            for(int w = 1; w <= K; w++){
                if(weights[i] <= w){
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]] + values[i]);
                }else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[N][K];
    }
}

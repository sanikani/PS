import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] dist = new int[n + 1][n + 1];
            int INF = 1005;
            Arrays.fill(dist[0], INF);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        dist[i][j] = 0;
                    } else if (val == 1) {
                        dist[i][j] = 1;
                    }else{
                        dist[i][j] = INF;
                    }
                }
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            int min = Arrays.stream(dist).mapToInt(d -> Arrays.stream(d).sum()).min().getAsInt();
            sb.append('#').append(tc).append(' ').append(min).append('\n');
        }
        System.out.println(sb);
    }
}

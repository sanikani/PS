import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        int[][][] dist = new int[N + 1][N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val != 0) {
                    Arrays.fill(dist[i][j], val);
                    Arrays.fill(dist[j][i], val);
                }
            }
        }

        final int INF = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i != j && dist[i][j][1] == 0) Arrays.fill(dist[i][j], INF);
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j][k] = dist[i][j][k - 1];
                    if (dist[i][k][k - 1] != INF && dist[k][j][k - 1] != INF) {
                        dist[i][j][k] = Math.min(dist[i][j][k], dist[i][k][k - 1] + dist[k][j][k - 1]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int result = dist[s][e][c - 1];
            if (result == Integer.MAX_VALUE) {
                sb.append(-1);
            } else {
                sb.append(result);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}

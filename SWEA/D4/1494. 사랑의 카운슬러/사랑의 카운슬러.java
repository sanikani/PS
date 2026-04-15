import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static long[][] arr;
    static long min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new long[N][2];
            min = Long.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Long.parseLong(st.nextToken());
                arr[i][1] = Long.parseLong(st.nextToken());
            }
            dfs(0, 0, 0, 0, 0);
            sb.append('#').append(tc).append(' ').append(min).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(long xSum, long ySum, int idx, int plusCnt, int minusCnt) {
        if (idx == N) {
            min = Math.min(min, xSum * xSum + ySum * ySum);
            return;
        }

        if (plusCnt < N / 2) {
            dfs(xSum + arr[idx][0], ySum + arr[idx][1], idx + 1, plusCnt + 1, minusCnt);
        }
        if (minusCnt < N / 2) {
            dfs(xSum - arr[idx][0], ySum - arr[idx][1], idx + 1, plusCnt, minusCnt + 1);
        }
    }
}

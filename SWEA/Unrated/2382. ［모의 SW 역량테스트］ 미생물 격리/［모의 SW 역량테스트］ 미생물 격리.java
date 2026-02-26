import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static class Group {
        int r, c, amount, dir;
        Group(int r, int c, int amount, int dir) {
            this.r = r;
            this.c = c;
            this.amount = amount;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Group> groups = new ArrayList<>(K);
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1; // 1~4 -> 0~3
                groups.add(new Group(r, c, amount, dir));
            }

            sb.append('#').append(tc).append(' ').append(simulate(N, M, groups)).append('\n');
        }

        System.out.print(sb);
    }

    private static int simulate(int n, int m, List<Group> groups) {
        int[][] sum = new int[n][n];
        int[][] max = new int[n][n];
        int[][] dirArr = new int[n][n];

        for (int t = 0; t < m; t++) {

            for (Group g : groups) {
                int nr = g.r + dr[g.dir];
                int nc = g.c + dc[g.dir];

                int amount = g.amount;
                int ndir = g.dir;

                if (nr == 0 || nr == n - 1 || nc == 0 || nc == n - 1) {
                    amount >>= 1;
                    ndir ^= 1;
                    if (amount == 0) continue;
                }

                sum[nr][nc] += amount;

                if (amount > max[nr][nc]) {
                    max[nr][nc] = amount;
                    dirArr[nr][nc] = ndir;
                }
            }

            // 2) groups 재구성 + 배열 초기화(다음 step 준비를 스캔 과정에서 같이)
            groups.clear();
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int s = sum[r][c];
                    if (s > 0) {
                        groups.add(new Group(r, c, s, dirArr[r][c]));
                        sum[r][c] = 0;
                        max[r][c] = 0;
                    }
                }
            }
        }

        int remain = 0;
        for (Group g : groups) remain += g.amount;
        return remain;
    }
}
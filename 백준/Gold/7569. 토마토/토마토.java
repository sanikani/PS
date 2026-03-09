import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[] dh = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] grid = new int[n][m][h];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < h; i++){
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    grid[j][k][i] = Integer.parseInt(st.nextToken());
                    if(grid[j][k][i] == 1) q.offer(new int[]{j, k, i});
                }
            }
        }

        System.out.println(solution(n, m, h, grid, q));
    }

    private static int solution(int n, int m, int height, int[][][] grid, Queue<int[]> q) {
        int day = -1;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int h = cur[2];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if(grid[nr][nc][h] == 0){
                        q.offer(new int[]{nr, nc, h});
                        grid[nr][nc][h] = 1;
                    }
                }

                for(int d = 0; d < 2; d++){
                    int nh = h + dh[d];
                    if(nh < 0 || nh >= height) continue;
                    if(grid[r][c][nh] == 0){
                        q.offer(new int[]{r, c, nh});
                        grid[r][c][nh] = 1;
                    }
                }
            }
            day++;
        }

        if(Arrays.stream(grid).flatMap(Arrays::stream).flatMapToInt(Arrays::stream).anyMatch(i -> i == 0)){
            return -1;
        }

        return day;
    }

}

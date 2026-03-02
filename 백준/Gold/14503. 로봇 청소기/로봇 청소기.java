import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(startR, startC, dir, grid, N, M));
    }

    private static int solution(int r, int c, int dir, int[][] grid, int N, int M) {
        int cnt = 0;

        while (true) {
            if (grid[r][c] == 0) {
                grid[r][c] = -1;
                cnt++;
            }

            boolean canRotate = false;
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (grid[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    canRotate = true;
                    break;
                }
            }

            if (!canRotate) {
                int nr = r + dr[(dir + 2) % 4];
                int nc = c + dc[(dir + 2) % 4];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || grid[nr][nc] == 1) return cnt;
                r = nr;
                c = nc;
            }
        }
    }

}

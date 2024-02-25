package section08;

import java.util.Scanner;

public class 섬나라아일랜드 {
    static int[][] map;
    static int n;
    int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    static int cnt = 0;
    public static void main(String[] args) {
        섬나라아일랜드 T = new 섬나라아일랜드();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }
        T.solution();
        System.out.println(cnt);
    }

    public void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                    DFS(j,i);
                }
            }
        }
    }

    private void DFS(int x, int y) {
        map[y][x] = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (map[ny][nx] == 1) {
                    DFS(nx, ny);
                }
            }
        }

    }
}

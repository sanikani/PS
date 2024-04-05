import java.util.*;
import java.io.*;
public class Main {
    static int[][] map;
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        map = new int[n+1][m+1];
        ch = new int[n + 1][m+1];
        for (int i = 1; i <= n; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                map[i][j]= Integer.parseInt(arr[j-1]);
            }
        }
        ch[1][1] = 1;
        System.out.println(BFS(1, 1));
    }

    public static int BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        int cnt = 0;
        Q.offer(new Point(x, y));
        while (!Q.isEmpty()) {
            int len = Q.size();

            cnt++;
            for (int i = 0; i < len; i++) {
                Point tmp = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && ch[nx][ny] == 0 && map[nx][ny] == 1) {
                        if (nx == n && ny == m) {
                            return cnt + 1;
                        }
                        ch[nx][ny] = 1;
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return cnt;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
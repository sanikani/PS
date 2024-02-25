package section08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬나라아일랜드BFS {
    static int[][] map;
    static int n;
    int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    static int answer = 0;
    Queue<Point> Q = new LinkedList();
    public static void main(String[] args) {
        섬나라아일랜드BFS T = new 섬나라아일랜드BFS();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }
        T.solution();
        System.out.println(answer);
    }

    private void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    answer++;
                    map[i][j] = 0;
                    BFS(j, i);
                }
            }
        }
    }

    public void BFS(int x, int y) {
        Q.offer(new Point(x, y));
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int j = 0; j < 8; j++) {
                int nx = tmp.x + dx[j];
                int ny = tmp.y + dy[j];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[ny][nx] == 1) {
                        map[ny][nx] = 0;
                        Q.offer(new Point(nx, ny));
                    }
                }
            }

        }
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

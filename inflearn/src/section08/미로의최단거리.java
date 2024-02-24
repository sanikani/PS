package section08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로의최단거리 {
    static int[][] board = new int[7][7];
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        미로의최단거리 T = new 미로의최단거리();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = in.nextInt();
            }
        }
        board[0][0] = 1;
        System.out.println(T.BFS(0, 0));
    }

    private int BFS(int x, int y) {
        Queue<Location> Q = new LinkedList<>();
        Q.offer(new Location(x, y));
        int l = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Location cur = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx == 6 && ny == 6) {
                        return l + 1;
                    }
                    if (nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6) {
                        if (board[nx][ny] == 0) {
                            board[nx][ny] = 1;
                            Q.offer(new Location(nx, ny));
                        }
                    }
                }
            }
            l++;
        }
        return -1;
    }

    static class Location {
        public int x;
        public int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

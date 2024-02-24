package section08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
    static int[][] box;
    static int[][] ch;
    static int n,m;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        토마토 T = new 토마토();
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        box = new int[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = in.nextInt();
            }
        }
        System.out.println(T.BFS());

    }

    public int BFS() {
        Queue<Location> Q = new LinkedList<>();
        Queue<Location> C = new LinkedList<>();
        int l = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    Q.offer(new Location(j, i));
                }
            }
        }
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Location tmp = Q.poll();
                int cnt = 0;
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (box[ny][nx] == 1) {
                            ch[tmp.y][tmp.x] = 1;
                            C.offer(new Location(tmp.x, tmp.y));
                        } else if (box[ny][nx] == -1) {
                            cnt++;
                        }
                    } else if (nx >= 0 || nx < m || ny >= 0 || ny < n) {
                        cnt++;
                    }
                    if (cnt == 4) {
                        return -1;
                    }

                }
                if (ch[tmp.y][tmp.x] == 0) {
                    Q.offer(new Location(tmp.x, tmp.y));
                }
            }
            int cLen = C.size();
            for (int k = 0; k < cLen; k++) {
                Location poll = C.poll();
                box[poll.y][poll.x] = 1;
            }
            l++;
        }
        return l;
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

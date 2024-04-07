import java.io.*;
import java.util.*;

public class Main {
    static int L, R, N;
    static int[][] arr;
    static int[][] ch;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        ch = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {

        Queue<Point> Q = new LinkedList<>();

        List<List<Point>> points = new ArrayList<>();
        List<Integer> avgs = new ArrayList<>();
        int day = 0;
        boolean isCount = true;

        while (isCount) {
            isCount = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    List<Point> list = new ArrayList<>();
                    if (ch[i][j] == 1) {
                        continue;
                    }

                    Q.offer(new Point(i, j));
                    int sum = arr[i][j];
                    list.add(new Point(i, j));
                    ch[i][j] = 1;

                    while (!Q.isEmpty()) {
                        int len = Q.size();
                        Point tmp = Q.poll();

                        for (int k = 0; k < len; k++) {
                            for (int q = 0; q < 4; q++) {

                                int nx = tmp.x + dx[q];
                                int ny = tmp.y + dy[q];

                                if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch[nx][ny] == 0) {
                                    int abs = Math.abs(arr[tmp.x][tmp.y] - arr[nx][ny]);

                                    if (abs >= L && abs <= R) {
                                        isCount = true;
                                        ch[nx][ny] = 1;
                                        sum += arr[nx][ny];
                                        Point p = new Point(nx, ny);
                                        Q.offer(p);
                                        list.add(p);
                                    }
                                }
                            }
                        }
                    }

                    if (list.size()>1) {
                        for (Point point : list) {
                        }
                        points.add(list);
                        avgs.add(sum / list.size());
                    }

                }
            }
            if (isCount) {
                day++;

                for (int i = 0; i < points.size(); i++) {
                    List<Point> pointList = points.get(i);
                    for (int j = 0; j < pointList.size(); j++) {
                        arr[pointList.get(j).x][pointList.get(j).y] = avgs.get(i);
                    }
                }
            }
            avgs.clear();
            points.clear();
            for (int[] a : ch) {
                Arrays.fill(a, 0);
            }
        }
        return day;
    }


    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
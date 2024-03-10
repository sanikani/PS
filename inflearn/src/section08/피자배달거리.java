package section08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 피자배달거리 {
    static List<Point> home = new ArrayList<>();
    static List<Point> pizza = new ArrayList<>();
    static int n,m;
    static int[] index;
    static int answer = Integer.MAX_VALUE;
    public void DFS(int l,int s) {
        if (l == m) {
            int sum = getSum();
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < pizza.size(); i++) {
                index[l] = i;
                DFS(l + 1, i + 1);
            }
        }
    }

    private int getSum() {
        int sum = 0;
        for (Point point : home) {
            int dis = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                Point pizaaPoint = pizza.get(index[j]);
                dis = Math.min(dis,Math.abs(point.x - pizaaPoint.x) + Math.abs(point.y - pizaaPoint.y));
            }
            sum += dis;
        }
        return sum;
    }

    public static void main(String[] args) {
        피자배달거리 T = new 피자배달거리();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        index = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = in.nextInt();
                if (tmp == 1) {
                    home.add(new Point(i, j));
                } else if (tmp == 2) {
                    pizza.add(new Point(i, j));
                }
            }
        }
        T.DFS(0,0);
        System.out.println(answer);
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

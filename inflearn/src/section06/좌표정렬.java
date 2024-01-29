package section06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 좌표정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i<n; i++) {
            String[] tmp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
        }
        int[][] solution = solution(n, arr);
        for (int j=0;j<n;j++) {
            System.out.println(solution[j][0] + " "+ solution[j][1]);
        }
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Point(arr[i][0], arr[i][1]));
        }
        Collections.sort(list);
        for(Point x : list) System.out.println(x.x + " " + x.y);
    }

    private static int[][] solution(int n, int[][] arr) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j][0] > arr[j + 1][0]) {
                    int[] temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else if (arr[j][0] == arr[j + 1][0]) {
                    if (arr[j][1] > arr[j + 1][1]) {
                        int[] temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        return arr;
    }

    static class Point implements Comparable<Point> {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y-o.y;
            } else return this.x - o.x;
        }
    }

}

package section09;

import java.util.Arrays;
import java.util.Scanner;

public class 다익스트라 {
    static int[][] arr;
    static int n;
    static int[] answer;
    static int[] ch;
    public static void main(String[] args) {
        다익스트라 T = new 다익스트라();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            arr[in.nextInt()][in.nextInt()] = in.nextInt();
        }
        answer = new int[n+1];
        Arrays.fill(answer,Integer.MAX_VALUE);
        ch = new int[n + 1];
        T.DFS(1,0);
        for (int i = 2; i <= n; i++) {
            if (answer[i]==Integer.MAX_VALUE) {
                System.out.println(i+" : impossible");
            } else {
                System.out.println(i+" : "+answer[i]);
            }
        }
    }

    public void DFS(int l, int dis) {
        if (dis != 0) {
            answer[l] = Math.min(answer[l], dis);
        }
        for (int i = 1; i <= n; i++) {
            if (arr[l][i] != 0 && ch[i] == 0) {
                ch[i] = 1;
                DFS(i, dis + arr[l][i]);
                ch[i] = 0;
            }
        }

    }
}

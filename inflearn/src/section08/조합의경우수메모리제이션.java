package section08;

import java.util.Scanner;

public class 조합의경우수메모리제이션 {
    static int[][] dy;
    public static void main(String[] args) {
        조합의경우수메모리제이션 T = new 조합의경우수메모리제이션();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        dy = new int[n + 1][n + 1];
        System.out.println(T.DFS(n, r));

    }

    private int DFS(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }
}

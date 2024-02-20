package section08;

import java.util.Scanner;

public class 수열추측하기조합 {
    static int n,f;
    static int[] ch,b,p;
    boolean flag = false;
    static int[][] dy;

    public static void main(String[] args) {
        수열추측하기조합 T = new 수열추측하기조합();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        dy = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        T.DFS(0, 0);

    }

    public void DFS(int l, int sum) {
        if (flag) {
            return;
        }
        if (l == n) {
            if (sum == f) {
                flag = true;
                for (int i : p) {
                    System.out.print(i+" ");
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i]=1;
                    p[l] = i;
                    DFS(l + 1, sum+(p[l]*b[l]));
                    ch[i] = 0;
                }
            }
        }
    }

    private int combi(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

}

package section08;

import java.util.Scanner;

public class 최대점수구하기 {
    static int n,m,max=0;
    static int[] time,score;
    static int tSum, sSum = 0;
    public void DFS(int l) {
        if(tSum>m) return;
        if (l == n) {
            if (tSum <= m && sSum > max) {
                max = sSum;
            }
        } else {
            tSum += time[l];
            sSum += score[l];
            DFS(l + 1);
            tSum -= time[l];
            sSum -= score[l];
            DFS(l + 1);
        }
    }

    public static void main(String[] args) {
        최대점수구하기 T = new 최대점수구하기();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        time = new int[n];
        score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
            time[i] = in.nextInt();
        }
        T.DFS(0);
        System.out.println(max);
    }
}

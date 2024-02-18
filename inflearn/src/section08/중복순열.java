package section08;

import java.util.Scanner;

public class 중복순열 {
    static int n, m;
    static int[] answer;
    public static void main(String[] args) {
        중복순열 T = new 중복순열();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        answer = new int[m];
        T.DFS(0);

    }

    private void DFS(int l) {
        if (l == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                answer[l] = i;
                DFS(l+1);
            }
        }
    }
}
